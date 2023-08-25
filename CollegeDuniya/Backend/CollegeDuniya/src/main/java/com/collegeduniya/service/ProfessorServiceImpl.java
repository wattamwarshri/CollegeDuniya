package com.collegeduniya.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeduniya.custom_exceptions.ResourceNotFoundException;
import com.collegeduniya.dto.ProfessorDto;
import com.collegeduniya.entities.Department;
import com.collegeduniya.entities.Professor;
import com.collegeduniya.repository.DepartmentRepository;
import com.collegeduniya.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addProfessor(ProfessorDto professorDto) {
		Department department = departmentRepo.findByDepartmentName(professorDto.getDepartmentName())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id !!!"));
		Professor professor = mapper.map(professorDto, Professor.class);
		Professor persistentProfessor = professorRepo.save(professor);
		department.addProfessor(persistentProfessor);
		return "Professor: "+persistentProfessor.getFirstName()+" "+persistentProfessor.getLastName()+ " added successfully";
	}
	
	@Override
	public ProfessorDto getProfessorById(Long id) {
		Professor professor = professorRepo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Invalid id"));
		ProfessorDto professorDto = mapper.map(professor, ProfessorDto.class);
		professorDto.setDepartmentName(professor.getDepartment().getDepartmentName());
		return professorDto;
	}

}
