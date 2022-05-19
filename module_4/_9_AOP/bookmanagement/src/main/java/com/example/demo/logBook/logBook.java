package com.example.demo.logBook;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class logBook {

    private Logger logger = Logger.getLogger(logBook.class.getName());

    @Pointcut("execution(* com.example.demo.controller.BookController.*())")
    public void bookService(){
    };

    @AfterReturning("bookService()")
    public void getLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
        System.err.println(methodName);
    }

    @Around("bookService()")
    public void getAllLog(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
        System.err.println(Throwable.class.getName());
    }

}
