package com.example.demo.dto;

import com.example.demo.entity.AttachService;
import com.example.demo.entity.Contract;

import javax.persistence.ManyToOne;

public class DtoContractDetail {
    private Long id;
    private int quanlity;

    @ManyToOne(targetEntity = Contract.class)
    Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    AttachService attachService;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DtoContractDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
