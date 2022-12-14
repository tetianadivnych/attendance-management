package com.project.attendancemanagementsystem.converter;

import com.project.attendancemanagementsystem.entity.Schedule;
import com.project.attendancemanagementsystem.model.ScheduleResponse;
import com.project.attendancemanagementsystem.entity.Student;
import com.project.attendancemanagementsystem.model.StudentResponse;

public class EntityConverter {

    public static StudentResponse convertStudent(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        ScheduleResponse scheduleResponse = convertSchedule(student.getSchedule());
        Long scheduleResponseId = scheduleResponse.getId();
        response.setScheduleId(scheduleResponseId);
        return response;
    }

    public static ScheduleResponse convertSchedule(Schedule schedule) {
        ScheduleResponse response = new ScheduleResponse();
        response.setId(schedule.getId());
        response.setNumberOfHours(schedule.getNumberOfHours());
        return response;
    }
}
