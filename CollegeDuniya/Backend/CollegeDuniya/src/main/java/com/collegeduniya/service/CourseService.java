package com.collegeduniya.service;

import com.collegeduniya.dto.CourseDto;

public interface CourseService {
	
	String addCourse(CourseDto courseDto);
	CourseDto getCourseById(Long id);
}
