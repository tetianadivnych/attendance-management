package com.project.attendancemanagementsystem.service;

import com.project.attendancemanagementsystem.converter.EntityConverter;
import com.project.attendancemanagementsystem.entity.Schedule;
import com.project.attendancemanagementsystem.entity.Student;
import com.project.attendancemanagementsystem.model.StudentRequest;
import com.project.attendancemanagementsystem.model.StudentResponse;
import com.project.attendancemanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ScheduleService scheduleService;

    public StudentService(StudentRepository studentRepository, ScheduleService scheduleService) {
        this.studentRepository = studentRepository;
        this.scheduleService = scheduleService;
    }

    public List<StudentResponse> getStudents() {
        return studentRepository.findAll().stream()
                .map(student -> EntityConverter.convertStudent(student))
                .collect(Collectors.toList());
    }

    public void addStudent(StudentRequest request) {
        Schedule existingSchedule = scheduleService.getScheduleById(request.getScheduleId());
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setSchedule(existingSchedule);
        studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException
                        ("Student with id" + studentId + " is not registered"));
    }

    public void updateStudent(StudentRequest inputData) {
        Student registeredStudent = getStudentById(inputData.getId());
        registeredStudent.setFirstName(inputData.getFirstName());
        registeredStudent.setLastName(inputData.getLastName());
        Schedule schedule = scheduleService.getScheduleById(inputData.getScheduleId());
        registeredStudent.setSchedule(schedule);
        studentRepository.save(registeredStudent);
    }

    public void deleteStudent(List<Long> ids) {
        studentRepository.deleteAllById(ids);
    }

}
