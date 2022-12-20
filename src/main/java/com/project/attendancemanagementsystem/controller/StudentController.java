package com.project.attendancemanagementsystem.controller;

import com.project.attendancemanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

}
