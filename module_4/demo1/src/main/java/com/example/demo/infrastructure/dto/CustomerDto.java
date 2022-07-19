package com.example.demo.infrastructure.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDto {
    private Long id;
    @NotEmpty( message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Từ 5-45 ký tự")
    private String name;

    @NotEmpty( message = "Không được để trống.")
    private String phone;

    @NotEmpty( message = "Không được để trống.")
    private String address;

    private boolean flag;

    public CustomerDto() {
    }

    public CustomerDto(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
