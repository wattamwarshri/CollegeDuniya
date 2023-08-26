package com.collegeduniya.service;

import com.collegeduniya.dto.SubjectDto;

public interface SubjectService {
	
	   String addSubject(SubjectDto subjectDto);
	   
	   String updateSubjectDetails(SubjectDto subjectDto, Long subjectId);
	   
	   String deleteSubjectById(Long subjectId);
}
