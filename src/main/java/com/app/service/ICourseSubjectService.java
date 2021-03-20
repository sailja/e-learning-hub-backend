package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.dto.CourseSubjectDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Subjects;

public interface ICourseSubjectService {

	ResponseDTO addCourseSubject(CourseSubjectDTO courseSubject);
	ResponseDTO removeCourseSubject(CourseSubjectDTO courseSubject);
	Set<Subjects> getCourseSubject(String courseName);
	
}
