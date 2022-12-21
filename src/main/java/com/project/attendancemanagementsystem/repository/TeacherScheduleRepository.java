package com.project.attendancemanagementsystem.repository;

import com.project.attendancemanagementsystem.entity.TeacherSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherScheduleRepository extends JpaRepository<TeacherSchedule, Long>{


}
