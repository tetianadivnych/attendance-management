package com.project.attendancemanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;


@Entity
public class Schedule {

    @Id
    private Long id;
    @OneToMany(mappedBy = "schedule")
    private List<Student> students = new ArrayList<>();

    private Integer numberOfHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }
}
