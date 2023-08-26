package com.collegeduniya.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.SubjectDto;
import com.collegeduniya.entities.Professor;
import com.collegeduniya.entities.Subject;
import com.collegeduniya.repository.ProfessorRepository;
import com.collegeduniya.repository.SubjectRepository;
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository subRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProfessorRepository profRepo;


	@Override
	public String addSubject(SubjectDto subjectDto) {
		// TODO Auto-generated method stub
        Professor prof = this.profRepo.findByFirstName(subjectDto.getProfessorName()).orElseThrow(() -> new ResourceNotFoundException("professor Id is not found"));
		
		Subject sub = this.modelMapper.map(subjectDto,Subject.class);
		
		Subject newSubject = this.subRepo.save(sub);
		
	    prof.addsubject(newSubject);
		return newSubject.getSubjectName()+"subject added successfully";
	}
	
	@Override
	public String updateSubjectDetails(SubjectDto subjectDto, Long subjectId) {
		
		Subject subject = subRepo.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		Professor prof = this.profRepo.findByFirstName(subjectDto.getProfessorName()).orElseThrow(() -> new ResourceNotFoundException("professor name was not found"));
		subject.setProfessor(prof);
		this.subRepo.save(subject);
		modelMapper.map(subjectDto, subject);
		
		
 		return subject.getSubjectName()+"successfully Updated";
		
		
	}

}
