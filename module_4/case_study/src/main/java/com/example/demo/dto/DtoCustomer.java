package com.example.demo.dto;

import com.example.demo.entity.Contract;
import com.example.demo.entity.CustomerType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class DtoCustomer {
    private Long id;

    @ManyToOne(targetEntity = CustomerType.class)
    private CustomerType customerType;

    @NotEmpty( message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Từ 5-45 ký tự")
    private String name;

    @NotNull(message = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private String birtday;

    private Boolean gender;

    @NotNull(message = "Bắt buộc")
    @Pattern(regexp = "^[0-9]{9,12}$",message = "idcart phải từ 9-12 số")
    private String idCard;

    @Pattern(regexp = "^((84(\\+|))|0)(90|91)+([0-9]{7})$", message = "Số điện thoại không đúng định dạng")
    private String phone;

    @Pattern(regexp = "^[0\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email không hợp lệ")
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer")
    List<Contract> contracts;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DtoCustomer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
