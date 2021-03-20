package com.app.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CourseRepository;
import com.app.dto.LoginDTO;
import com.app.dto.PaymentDTO;
import com.app.dto.ResponseDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserTestDTO;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.CourseSubjectServiceImpl;
import com.app.service.IPaymentService;
import com.app.service.IQuestionService;
import com.app.service.ITestService;
import com.app.service.IUserService;
import com.app.service.IUserTestService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;
	@Autowired
	private IQuestionService questionsService;
	@Autowired
	private ITestService testService;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private CourseSubjectServiceImpl courseSubjectService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IUserTestService userTestService;
	
	// REST request handling method to add a new user
	@PostMapping("/signup")
	public ResponseDTO<?> addUserDetails(@RequestBody UserDTO userDTO) {
		userDTO.setRole(Role.USER);
		System.out.println("in add user details " + userDTO);
		return new ResponseDTO<>(HttpStatus.OK, "User details added", userService.addUserDetails(userDTO));
	}

	@PostMapping("/login")
	public ResponseDTO<?> authenticateUser(@RequestBody LoginDTO request) {
		System.out.println("in auth " + request);
		User user = userService.authenticateUser(request.getEmail(), request.getPassword());
		if (user != null)
			return new ResponseDTO<>(HttpStatus.OK, "success", user);
		else
			return new ResponseDTO<>(HttpStatus.UNAUTHORIZED, "error", "Invalid Credentials");
	
	}
	@PutMapping("/update/{userId}")
	public ResponseDTO<?> updateUserDetails(@PathVariable int userId, @RequestBody UserDTO userDTO) {
		System.out.println("in rest : update details " + userId + " " + userDTO);
		userDTO.setRole(Role.USER);
		return new ResponseDTO<>(HttpStatus.OK, "Updated user details",
				userService.updateUserDetails(userId, userDTO));
	}
	@GetMapping("/userdetails/{userId}")
	public ResponseDTO<?> getUserDetails(@PathVariable int userId) {
		System.out.println("in get user dtls " + userId);
		return new ResponseDTO<>(HttpStatus.OK, "User details", userService.getUserDetails(userId));
		}
	
	
	@GetMapping("/questions/{testId}")
	public ResponseDTO<?> getQuestions(@PathVariable int testId) {
		System.out.println("in get user dtls " + testId);
		return new ResponseDTO<>(HttpStatus.OK, "User details", questionsService.getquestionsByTestId(testId));
		}
	
	@GetMapping("/tests/{testId}")
	public ResponseDTO<?> getTests(@PathVariable int testId) {
		System.out.println("in get Test dtls " + testId);
		return new ResponseDTO<>(HttpStatus.OK, "Test details", testService.getTestDetails(testId));
		}
	
	@GetMapping("/courseList")
	public ResponseDTO<?> getAllCourses() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", courseRepo.getAllCourses());
	}
	
	@GetMapping("/subjects/{courseName}")
	public ResponseDTO<?> getSubjects(@PathVariable String courseName) {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", courseSubjectService.getCourseSubject(courseName));
	}
	
	@PostMapping("/Payment")
	public ResponseDTO<?> Payment(@RequestBody PaymentDTO paymentDto) {
		System.out.println("in add user details " + paymentDto);
		
		
		return new ResponseDTO<>(HttpStatus.OK, "User details added",paymentService.addPaymentDetails(paymentDto) );
	}
	
	
	@PostMapping("/UserTest")
	public ResponseEntity<?> addUserTest(@RequestBody @Valid UserTestDTO userTest)
	{
		System.out.println("in place order "+userTest);
		return new ResponseEntity<>(userTestService.addUserTest(userTest), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/userTest/{userId}")
	public ResponseDTO<?> getUserTest(@PathVariable int userId) {
		System.out.println("in get  users test");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching test list successfully", userTestService.getUserTest(userId));
	}
	

}
