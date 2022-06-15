package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KhuyenMaiDto {

    private Long id;

    @NotEmpty( message = "Không được để trống.")
    private String title;

    @NotEmpty( message = "Không được để trống.")
    private String startDay;

    @NotEmpty( message = "Không được để trống.")
    private String endDay;

    @NotNull( message = "Không được để trống.")
    @Min(value = 10000)
    private int money;

    @NotEmpty( message = "Không được để trống.")
    private String detail;

    private boolean flag;

    public KhuyenMaiDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
