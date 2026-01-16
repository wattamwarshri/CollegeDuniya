package com.collegeduniya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
