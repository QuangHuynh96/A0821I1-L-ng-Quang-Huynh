package com.example.demo.validator;

import com.example.demo.dto.DtoContract;
import com.example.demo.dto.DtoService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof DtoContract)) {
            return;
        }
        DtoContract dtoContract = (DtoContract) target;
        if(dtoContract.getEmployee().getId()==null) {
            errors.rejectValue("employee", "", "please set employee");
        }
        if(dtoContract.getCustomer().getId()==null) {
            errors.rejectValue("customer", "", "please set customer");
        }
        if(dtoContract.getService().getId()==null) {
            errors.rejectValue("service", "", "please set service");
        }
    }
}
