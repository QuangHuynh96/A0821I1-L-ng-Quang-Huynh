package com.example.demo.validator;

import com.example.demo.dto.DtoEmployee;
import com.example.demo.dto.DtoService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServiceValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof DtoService)) {
            return;
        }

        DtoService dtoService = (DtoService) target;
        if (dtoService.getServiceType().getId() == null) {
            errors.rejectValue("serviceType", "", "Không được null");
        }
        if (dtoService.getRentType().getId() == null) {
            errors.rejectValue("rentType", "", "Không được null");
        }
    }
}
