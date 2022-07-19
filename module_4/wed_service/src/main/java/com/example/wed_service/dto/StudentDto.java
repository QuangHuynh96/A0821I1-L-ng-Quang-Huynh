package com.example.wed_service.dto;

import com.example.wed_service.Entity.Group;
import com.example.wed_service.Entity.Teacher;

import javax.persistence.ManyToOne;

public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    @ManyToOne(targetEntity = Group.class)
    private Group group;
    @ManyToOne(targetEntity = Teacher.class)
    private Teacher teacher;
    private boolean flag;

    public StudentDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
