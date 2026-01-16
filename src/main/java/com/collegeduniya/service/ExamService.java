package com.collegeduniya.service;

import java.util.List;

import com.collegeduniya.dto.ExamDto;

public interface ExamService {

	 String addExam(ExamDto examDto);
	 
	  String updateExamDetails(ExamDto examDto, Long examId);
	  
	  String deleteExamById(Long examId);
	  
	  List<ExamDto> getAllExam();
	  
	  ExamDto getExamById(Long examId);
	  
	  List<ExamDto> getAllExamsByDepartmentName(String deptName);
}
