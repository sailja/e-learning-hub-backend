package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseSubjectDTO;
import com.app.service.ICourseSubjectService;

@RestController
@RequestMapping("/CourseSubjects")
public class CourseSubjectController {

	
	
	@Autowired
	private ICourseSubjectService courseSubjectService;
	
	
	

	@PostMapping
	public ResponseEntity<?> addCourseSubject(@RequestBody @Valid CourseSubjectDTO courseSubject)
	{
		System.out.println("in place order "+courseSubject);
		return new ResponseEntity<>(courseSubjectService.addCourseSubject(courseSubject), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeCourseSubject(@RequestBody @Valid CourseSubjectDTO courseSubject)
	{
		System.out.println("in place order "+courseSubject);
		return new ResponseEntity<>(courseSubjectService.removeCourseSubject(courseSubject), HttpStatus.CREATED);
		
	}
}
