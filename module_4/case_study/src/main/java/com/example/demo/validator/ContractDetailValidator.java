package com.example.demo.validator;

import com.example.demo.dto.DtoContractDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof DtoContractDetail)) {
            return;
        }
        DtoContractDetail dtoContractDetail = (DtoContractDetail) target;

        if(dtoContractDetail.getAttachService().getId() == null) {
            errors.rejectValue("attachService","", "please set attachService");
        }

    }
}
