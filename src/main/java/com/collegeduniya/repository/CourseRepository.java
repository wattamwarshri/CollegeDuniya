package com.collegeduniya.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findByCourseName(String courseName);
	Optional<List<Course>> findAllByDepartmentDepartmentName(String deptName);
}
