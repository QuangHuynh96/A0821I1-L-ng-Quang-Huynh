package com.example.demo.validator;

import com.example.demo.dto.DtoCustomer;
import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(!(target instanceof DtoCustomer)) {
            return;
        }

        DtoCustomer dtoCustomer = (DtoCustomer) target;
        if (dtoCustomer.getCustomerType().getId() == null) {
            errors.rejectValue("customerType", "", "Không được null");
        }

    }
}
