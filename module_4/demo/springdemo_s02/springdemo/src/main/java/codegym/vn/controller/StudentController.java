package codegym.vn.controller;

import codegym.vn.entity.Student;
import codegym.vn.service.StudentService;
import codegym.vn.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    // setter injection: cách triển khai ngắn gọn, hay dùng
    @Autowired
//    @Qualifier("studentServiceImpl")
    private StudentService service;
    // triển
    // khai setter injection đầy đủ
//    @Autowired
//    @Qualifier("studentService1")
//    public void setService(StudentService service) {
//        this.service = service;
//    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Student> students = service.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
}
