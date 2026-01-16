package com.collegeduniya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Department;
import com.collegeduniya.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	List<Exam> findAllByDepartment(Department dept);
}
