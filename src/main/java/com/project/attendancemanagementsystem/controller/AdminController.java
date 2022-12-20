package com.project.attendancemanagementsystem.controller;

import com.project.attendancemanagementsystem.model.StudentRequest;
import com.project.attendancemanagementsystem.model.StudentResponse;
import com.project.attendancemanagementsystem.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentRequest studentRequest) {
        adminService.addStudent(studentRequest);
    }

    @GetMapping("/students")
    public List<StudentResponse> getStudents() {
        return adminService.getStudents();
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody StudentRequest request) {
        adminService.updateStudent(request);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestParam List<Long> ids) {
        adminService.deleteStudent(ids);
    }

}
