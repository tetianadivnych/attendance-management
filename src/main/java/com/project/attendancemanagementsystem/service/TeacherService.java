package com.project.attendancemanagementsystem.service;

import com.project.attendancemanagementsystem.entity.Teacher;
import com.project.attendancemanagementsystem.model.TeacherRequest;
import com.project.attendancemanagementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherScheduleService teacherScheduleService;

    public TeacherService(TeacherRepository teacherRepository, TeacherScheduleService teacherScheduleService) {
        this.teacherRepository = teacherRepository;
        this.teacherScheduleService = teacherScheduleService;
    }

    public void addTeacherWithSchedules(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacherRepository.save(teacher);
        teacherScheduleService.assignSchedules(request, teacher);
    }

}
