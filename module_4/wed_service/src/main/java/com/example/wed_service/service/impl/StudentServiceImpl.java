package com.example.wed_service.service.impl;

import com.example.wed_service.Entity.Student;
import com.example.wed_service.dto.StudentDto;
import com.example.wed_service.repository.StudentRepository;
import com.example.wed_service.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void save(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        student.setFlag(false);
        studentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudent(String key_name, String key_phoneNumber, String key_email, Pageable pageable) {
        return studentRepository.findAll( key_name, key_phoneNumber, key_email, pageable);
    }

    public List<Student> getAll() {
        return  studentRepository.findAll();
    }
}
