package com.project.attendancemanagementsystem.service;

import com.project.attendancemanagementsystem.model.Schedule;
import com.project.attendancemanagementsystem.model.Student;
import com.project.attendancemanagementsystem.model.StudentResponse;
import com.project.attendancemanagementsystem.repository.ScheduleRepository;
import com.project.attendancemanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ScheduleRepository scheduleRepository;

    public StudentService(StudentRepository studentRepository, ScheduleRepository scheduleRepository) {
        this.studentRepository = studentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<StudentResponse> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> EntityConverter.convertStudent(student))
                .collect(Collectors.toList());
    }

    public void addStudent(StudentRequest request) {
        Schedule existingSchedule = scheduleRepository.findById(request.getScheduleId()).orElseThrow(() -> new EntityNotFoundException("Schedule doesn't exist"));
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setSchedule(existingSchedule);
        studentRepository.save(student);
    }
}
