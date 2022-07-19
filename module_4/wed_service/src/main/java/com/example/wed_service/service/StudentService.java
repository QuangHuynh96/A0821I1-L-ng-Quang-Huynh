package com.example.wed_service.service;

import com.example.wed_service.Entity.Student;
import com.example.wed_service.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    void save(StudentDto studentDto);

    void delete(Student student);

    Page<Student> getAllStudent(String key_name, String key_phoneNumber, String key_email, Pageable pageable );

}
