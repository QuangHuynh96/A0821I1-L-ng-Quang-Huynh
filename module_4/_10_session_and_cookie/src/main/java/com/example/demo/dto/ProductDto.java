package com.example.demo.dto;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String description;

    @Min(0)
    private double newPrice;

    @Min(0)
    private double oldPrice;

    @NotEmpty
    private String linkImagel;

    public ProductDto(@NotNull String name, String description, @Min(0) double newPrice, @Min(0) double oldPrice, @NotEmpty String linkImagel) {
        this.name = name;
        this.description = description;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.linkImagel = linkImagel;
    }

    public String getLinkImagel() {
        return linkImagel;
    }

    public void setLinkImagel(String linkImagel) {
        this.linkImagel = linkImagel;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }
}
