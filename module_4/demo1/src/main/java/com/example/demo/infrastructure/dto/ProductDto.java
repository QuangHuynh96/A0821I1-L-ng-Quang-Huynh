package com.example.demo.infrastructure.dto;

import javax.validation.constraints.NotEmpty;

public class ProductDto {

    private Long id;

    @NotEmpty()
    private String name;

    @NotEmpty()
    private double price;

    @NotEmpty()
    private String Description;

    private boolean flag;

    public ProductDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
