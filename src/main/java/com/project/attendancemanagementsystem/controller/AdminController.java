package com.project.attendancemanagementsystem.controller;

import com.project.attendancemanagementsystem.model.StudentRequest;
import com.project.attendancemanagementsystem.model.StudentResponse;
import com.project.attendancemanagementsystem.model.TeacherRequest;
import com.project.attendancemanagementsystem.service.AdminService;
import com.project.attendancemanagementsystem.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final TeacherService teacherService;

    public AdminController(AdminService adminService, TeacherService teacherService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
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

    @PostMapping("/teachers")
    public void addTeacherWithSchedules(@RequestBody TeacherRequest request) {
        teacherService.addTeacherWithSchedules(request);
    }

}
