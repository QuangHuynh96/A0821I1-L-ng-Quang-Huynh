package com.example.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class DtoUser implements Validator {
    private Long id;

    @NotEmpty( message = "Khong duoc de kkhoan trang")
    @Size(min = 5, max = 45, message = "từ 5 đến 45 ký tự")
    private String firstName;
    
    @NotEmpty( message = "Khong duoc de kkhoan trang")
    @Size(min = 5, max = 45, message = "từ 5 đến 45 ký tự")
    private String lastName;

    @Positive
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải từ 18")
    private int age;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email không hợp lệ")
    private String email;

    public DtoUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DtoUser dtoUser = (DtoUser) target;
    }
}
