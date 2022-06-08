package com.example.demo.validator;

import com.example.demo.dto.DtoEmployee;
import com.example.demo.entity.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof DtoEmployee)) {
            return;
        }

        DtoEmployee employee = (DtoEmployee) target;
        if (employee.getPosition().getId() == null) {
                errors.rejectValue("position", "", "Không được null");
        }
        if (employee.getDivision().getId() == null) {
            errors.rejectValue("division", "", "Không được null");
        }
        if (employee.getEducationDegree().getId() == null) {
            errors.rejectValue("educationDegree", "", "Không được null");
        }
    }
}
