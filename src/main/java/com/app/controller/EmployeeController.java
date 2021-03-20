package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CourseRepository;
import com.app.dao.SubjectRepository;
import com.app.dao.TestRepository;
import com.app.dto.CourseDTO;
import com.app.dto.CourseSubjectDTO;
import com.app.dto.QuestionDTO;
import com.app.dto.ResponseDTO;
import com.app.dto.SubjectDTO;
import com.app.dto.TestDTO;
import com.app.pojos.Courses;
import com.app.pojos.Questions;
import com.app.pojos.Subjects;
import com.app.pojos.User;
import com.app.service.CourseSubjectServiceImpl;
import com.app.service.ICourseService;
import com.app.service.IQuestionService;
import com.app.service.ISubjectService;
import com.app.service.ITestService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private ITestService testservice;
	
	@Autowired
	private TestRepository testRepo;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private IQuestionService questionService;
	
	@Autowired
	private CourseSubjectServiceImpl courseSubjectService;
	
	
	
	@GetMapping("/list")
	public ResponseDTO<?> getAllUsers() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching user list successfully", userService.getAllusers());
	}
	
	
	@PostMapping("/add_course")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseDTO<?> addNewCourse(@Valid @RequestBody Courses courseRequest) {
		
		return new ResponseDTO<>(HttpStatus.OK, "Test details added", courseRepository.save(courseRequest));
	}
	
	@PostMapping("/add_subject")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseDTO<?> addNewSubject(@Valid @RequestBody Subjects subjectRequest) {
		
		return new ResponseDTO<>(HttpStatus.OK, "Test details added", subjectRepository.save(subjectRequest));
	}

	@PostMapping("/add_test/{subjectId}")
	public ResponseDTO<?> addTestDetails(@PathVariable int subjectId, @RequestBody TestDTO testDTO) {
		if(testDTO.getPrice()!=0) 
			testDTO.setPremium(true);
		
		System.out.println("in add test details " + testDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Test details added", testservice.addTestDetails(testDTO, subjectId));
	}
	

	@PutMapping("update_course/{coursesId}")
	public ResponseDTO<?> updateCoursesDetails(@PathVariable int coursesId, @RequestBody CourseDTO courseDTO) {
		System.out.println("in rest : update details " + coursesId + " " + courseDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated course details",
				courseService.updateCourseDetails(coursesId,  courseDTO));
	}
	
	@PutMapping("update_subject/{subjectsId}")
	public ResponseDTO<?> updateSubjectDetails(@PathVariable int subjectsId, @RequestBody SubjectDTO subjectDTO) {
		System.out.println("in rest : update details " + subjectsId + " " + subjectDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated subject details",
				subjectService.updateSubjectDetails(subjectsId, subjectDTO));
	}
	
	@PutMapping("update_test/{testId}")
	public ResponseDTO<?> updateTestDetails(@PathVariable int testId, @RequestBody TestDTO testDTO) {
		if(testDTO.getPrice()!=0) 
			testDTO.setPremium(true);
		
		System.out.println("in rest : update details " + testId + " " + testDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated Test details",
				testservice.updateTestDetails(testId, testDTO));
	}
	
	@GetMapping("/courseList")
	public ResponseDTO<?> getAllCourses() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", courseRepo.getAllCourses());
	}
	@PutMapping("updatequestion/{questionId}")
	public ResponseDTO<?> updateQuestions(@PathVariable int questionId,@RequestBody QuestionDTO questionDto)
	{
		return new ResponseDTO<>(HttpStatus.OK,"update question",questionService.updateQuestion(questionId, questionDto));
	}
	
	
	@GetMapping("/subjectList")
	public ResponseDTO<?> getAllSubjects() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", subjectRepo.getAllSubjects());
	}
	
	

	@GetMapping("/premium")
	public ResponseDTO<?> getAllPremiumUsers() {
		System.out.println("in get al users");
		List<User> u=userService.getAllusers();
		List<User> premium=new ArrayList<User>();
		for (User user : u) {
			if(user.getIsPremium())
			{
				premium.add(user);
			}
		}
		return new ResponseDTO<>(HttpStatus.OK, "Premium list added",premium );
	}
	@PostMapping("/add_question/{testId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Questions addNewquestion(@Valid @RequestBody QuestionDTO QuestionDTO ,@PathVariable int testId ) {
		
		return questionService.addNewQuestion(QuestionDTO, testId);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourseSubject(@RequestBody @Valid CourseSubjectDTO courseSubject)
	{
		System.out.println("in place order "+courseSubject);
		return new ResponseEntity<>(courseSubjectService.addCourseSubject(courseSubject), HttpStatus.CREATED);
		
	}
	
	

}
