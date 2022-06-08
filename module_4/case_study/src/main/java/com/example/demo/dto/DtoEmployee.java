package com.example.demo.dto;

import com.example.demo.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

public class DtoEmployee {
    private Long id;

    @NotEmpty( message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Từ 5-45 ký tự")
    private String name;

    @NotNull(message = "")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private String birtday;

    @NotNull(message = "Bắt buộc")
    @Pattern(regexp = "^[0-9]{9,12}$",message = "idcart phải từ 9-12 số")
    private String idCard;

    @Min(value = 0, message = "lỗi không được âm")
    private double salary;

    @Pattern(regexp = "^((84(\\+|))|0)(90|91)+([0-9]{7})$", message = "Số điện thoại không đúng định dạng")
    private String phone;

    @Pattern(regexp = "^[0\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email không hợp lệ")
    private String email;

    private String address;


    @ManyToOne(targetEntity = Position.class)
    private Position position;


    @ManyToOne(targetEntity = EducationDegree.class)
    @NotNull(message = "Bắt buộc")
    private EducationDegree educationDegree;


    @ManyToOne(targetEntity = Division.class)
    @NotNull(message = "Bắt buộc")
    private Division division;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @OneToMany(mappedBy = "employee")
    List<Contract> contracts;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public DtoEmployee() {
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

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
