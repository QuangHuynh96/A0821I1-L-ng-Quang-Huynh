package com.example.demo.config;


import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home","/login","/logout").permitAll();
//                .and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
        // Các trang yêu cầu quyền
            http.authorizeRequests().antMatchers( "/customer/**", "/contractDetail/**").access(
                "hasAnyRole('ROLE_USER','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/employee/**","/service/**").hasRole("ADMIN");

        // Nếu access không đúng quyền, giả sử Role_User vào trang /admin/**
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/");
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

        // Cấu hình remember me
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60 * 60 * 3); //3h
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Autowired
    DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // Tạo lưu trong bộ nhớ
        InMemoryTokenRepositoryImpl repository = new InMemoryTokenRepositoryImpl();
        return repository;


        // Tạo lưu trong DB, phải tạo bảng ở DB trước
//        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
//        repository.setDataSource(dataSource);
//        return repository;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}123456").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}123456").roles("ADMIN");
//    }
}
