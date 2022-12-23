package com.project.attendancemanagementsystem.model;

public class TeacherRequest {

    private String firstName;
    private String lastName;
    private Long studentSchedule;
    private Long employeeSchedule;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(Long studentSchedule) {
        this.studentSchedule = studentSchedule;
    }

    public Long getEmployeeSchedule() {
        return employeeSchedule;
    }

    public void setEmployeeSchedule(Long employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }
}
