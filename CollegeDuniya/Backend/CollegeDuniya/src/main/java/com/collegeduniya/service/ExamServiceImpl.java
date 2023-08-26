package com.collegeduniya.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.ExamDto;
import com.collegeduniya.entities.Department;
import com.collegeduniya.entities.Exam;
import com.collegeduniya.repository.DepartmentRepository;
import com.collegeduniya.repository.ExamRepository;

@Service
@Transactional
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamRepository examRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public String addExam(ExamDto examDto) {
		// TODO Auto-generated method stub
		//return null;
        Department dept = this.deptRepo.findByDepartmentName(examDto.getDepartmentName()).orElseThrow(() -> new ResourceNotFoundException("Department Id is not found"));
		
		Exam exam = this.modelMapper.map(examDto,Exam.class);
	
		Exam newExam = this.examRepo.save(exam);
		
	    dept.addExam(newExam);
		return newExam.getExamName()+" exam added successfully";
	}
	
	@Override
	public String updateExamDetails(ExamDto examDto, Long examId) {
		// TODO Auto-generated method stub
		Exam exam = examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		Department dept = this.deptRepo.findByDepartmentName(examDto.getDepartmentName()).orElseThrow(() -> new ResourceNotFoundException("department name was not found"));
		exam.setDepartment(dept);
		this.examRepo.save(exam);
		modelMapper.map(examDto, exam);
		
		
 		return exam.getExamName() +" successfully Updated";

	}
	
	@Override
	public String deleteExamById(Long examId) {
		// TODO Auto-generated method stub
		//return null;
        Exam exam = this.examRepo.findById(examId).orElseThrow(() -> new ResourceNotFoundException("exam Id was not found"));
		
		List<Exam> examList = examRepo.findAll();
		examList.remove(exam);
		examRepo.delete(exam);
		examRepo.saveAll(examList);
		return exam.getExamName()+" was removed";
		
		//this.subRepo.delete(sub);

	}
}