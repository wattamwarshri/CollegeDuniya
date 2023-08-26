package com.collegeduniya.service;

import com.collegeduniya.dto.ExamDto;

public interface ExamService {

	 String addExam(ExamDto examDto);
	 
	  String updateExamDetails(ExamDto examDto, Long examId);
	  
	  String deleteExamById(Long examId);
}