package com.example.demo.service.impl;

import com.example.demo.dto.DtoContractDetail;
import com.example.demo.entity.Contract;
import com.example.demo.entity.ContractDetail;
import com.example.demo.repository.ContractDetailRepository;
import com.example.demo.service.ContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public void save(DtoContractDetail dtoContractDetail) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(dtoContractDetail, contractDetail);
        contractDetail.setFlag(true);
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        contractDetail.setFlag(false);
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> getList(Long id) {
        return contractDetailRepository.getListByContractId(id);
    }
}
