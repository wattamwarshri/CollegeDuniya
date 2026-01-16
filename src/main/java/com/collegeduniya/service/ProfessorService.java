package com.collegeduniya.service;

import java.util.List;

import com.collegeduniya.dto.ProfessorDto;

public interface ProfessorService {
	
	String addProfessor(ProfessorDto professorDto);
	ProfessorDto getProfessorById(Long id);
	List<ProfessorDto> getAllProfessorByDepartmentName(String deptName);
	List<ProfessorDto> getAllProfessors();
	String updateProfessorDetails(ProfessorDto professorDto,Long id);
	String deleteProfessorById(Long id);
}
