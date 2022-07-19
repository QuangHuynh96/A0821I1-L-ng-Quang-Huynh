package com.example.wed_service.restController;

import com.example.wed_service.Entity.Student;
import com.example.wed_service.repository.StudentRepository;
import com.example.wed_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class StudentRestController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students/list/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<Student> getAllStudent(@RequestParam(defaultValue = "") String key_name,
                                       @RequestParam(defaultValue = "") String key_phoneNumber,
                                       @RequestParam(defaultValue = "") String key_email,
                                       @PageableDefault(size = 5) Pageable pageable) {
        Page<Student> students = studentService.getAllStudent(key_name, key_phoneNumber, key_email, pageable);
        return students;
    }

    @GetMapping("/students/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll() {
        return studentRepository.getStudent();
    }

    @DeleteMapping("/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Student student) {
        studentService.delete(student);
    }
}
