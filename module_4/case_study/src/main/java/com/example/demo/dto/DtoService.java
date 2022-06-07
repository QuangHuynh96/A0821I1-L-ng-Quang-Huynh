package com.example.demo.dto;

import com.example.demo.entity.RentType;
import com.example.demo.entity.ServiceType;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DtoService {

    private Long id;

    @NotEmpty( message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Từ 5-45 ký tự")
    private String name;

    @Min(value = 0, message = "lỗi không được âm")
    private int area;

    @Min(value = 0, message = "lỗi không được âm")
    private double cost;

    @Min(value = 0, message = "lỗi không được âm")
    private int maxPeople;

    @ManyToOne(targetEntity = RentType.class)
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;

    @NotEmpty( message = "Không được để trống.")
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "lỗi không được âm")
    private double poolArea;

    @Min(value = 0, message = "lỗi không được âm")
    private int numberOfFloors;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DtoService() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
