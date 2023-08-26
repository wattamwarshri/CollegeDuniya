package com.collegeduniya.service;

import java.util.List;

import com.collegeduniya.dto.SubjectDto;

public interface SubjectService {
	
	   String addSubject(SubjectDto subjectDto);
	   
	   String updateSubjectDetails(SubjectDto subjectDto, Long subjectId);
	   
	   String deleteSubjectById(Long subjectId);
	   
	   List<SubjectDto> getAllSubject();
	   
	   SubjectDto getSubjectById(Long subjectId);
	   
	   List<SubjectDto> getAllSubjectsByProfessorName(String profName);
}
