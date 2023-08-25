package com.collegeduniya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
