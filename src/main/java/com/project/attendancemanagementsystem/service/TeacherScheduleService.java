package com.project.attendancemanagementsystem.service;

import com.project.attendancemanagementsystem.entity.Schedule;
import com.project.attendancemanagementsystem.entity.Teacher;
import com.project.attendancemanagementsystem.entity.TeacherSchedule;
import com.project.attendancemanagementsystem.model.TeacherRequest;
import com.project.attendancemanagementsystem.repository.TeacherScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherScheduleService {
    private final TeacherScheduleRepository teacherScheduleRepository;
    private final ScheduleService scheduleService;

    public TeacherScheduleService(TeacherScheduleRepository teacherScheduleRepository, ScheduleService scheduleService) {
        this.teacherScheduleRepository = teacherScheduleRepository;
        this.scheduleService = scheduleService;
    }

    public void assignSchedules(TeacherRequest request, Teacher teacher) {
        TeacherSchedule teacherStudentSchedule = new TeacherSchedule();
        Long studentScheduleId = request.getStudentSchedule();
        Schedule existingStudentSchedule = scheduleService.getScheduleById(studentScheduleId);
        teacherStudentSchedule.setSchedule(existingStudentSchedule);
        teacherStudentSchedule.setTeacher(teacher);
        teacherScheduleRepository.save(teacherStudentSchedule);

        TeacherSchedule teacherEmployeeSchedule = new TeacherSchedule();
        Long employeeScheduleId = request.getEmployeeSchedule();
        Schedule existingEmployeeSchedule = scheduleService.getScheduleById(employeeScheduleId);
        teacherEmployeeSchedule.setSchedule(existingEmployeeSchedule);
        teacherEmployeeSchedule.setTeacher(teacher);
        teacherScheduleRepository.save(teacherEmployeeSchedule);
    }

}
