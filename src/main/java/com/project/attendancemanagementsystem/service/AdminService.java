package com.project.attendancemanagementsystem.service;

import com.project.attendancemanagementsystem.model.StudentRequest;
import com.project.attendancemanagementsystem.model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final StudentService studentService;

    public AdminService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(StudentRequest studentRequest) {
        studentService.addStudent(studentRequest);
    }

    public List<StudentResponse> getStudents() {
        return studentService.getStudents();
    }

    public void updateStudent(StudentRequest request) {
        studentService.updateStudent(request);
    }

    public void deleteStudent(List<Long> id) {
        studentService.deleteStudent(id);
    }

}
