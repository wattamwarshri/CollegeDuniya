package com.collegeduniya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegeduniya.entities.Professor;
import com.collegeduniya.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{

	 List<Subject> findAllByProfessor(Professor prof);
	//Optional<List<Subject>> findAllByProfessorProfessorName(String profName);
	
}
