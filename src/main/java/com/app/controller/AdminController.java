package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CourseRepository;
import com.app.dao.SubjectRepository;
import com.app.dto.ResponseDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Courses;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.CourseSubjectServiceImpl;
import com.app.service.IUserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private IUserService userService;
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	
	@GetMapping("/list")
	public ResponseDTO<?> getAllUsers() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching user list successfully", userService.getAllusers());
	}
	
	@PostMapping("/add")
	public ResponseDTO<?> addUserDetails(@RequestBody UserDTO userDTO) {
		userDTO.setRole(Role.EMPLOYEE);
		System.out.println("in add user details " + userDTO);
		return new ResponseDTO<>(HttpStatus.OK, "User details added", userService.addUserDetails(userDTO));
	}
	@PostMapping("/delete/{id}")
	public void deleteEmployeedetails(@PathVariable int id) {
		
		System.out.println("id " +id);
		userService.deleteUserDetails(id);

	}
	@PutMapping("/update/{userId}")
	public ResponseDTO<?> updateEmployeeDetails(@PathVariable int userId, @RequestBody UserDTO userDTO) {
		System.out.println("in rest : update details " + userId + " " + userDTO);
		return new ResponseDTO<>(HttpStatus.OK, "Updated user details",
				userService.updateEmployeeDetails(userId, userDTO));
	}
	@GetMapping("/user/list/{role}")
	public ResponseDTO<?> showUserDetails(@PathVariable Role role) {
	System.out.println("in show details");
	System.out.println(  userService.findAllByRole(role)    ); 
	return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", userService.findAllByRole(role));
}
	
	
	@GetMapping("/courseList")
	public ResponseDTO<?> getAllCourses() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", courseRepo.getAllCourses());
	}
	
	@GetMapping("/subjectList")
	public ResponseDTO<?> getAllSubjects() {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching courses list successfully", subjectRepo.getAllSubjects());
	}
	@GetMapping("/ispremium/list/{id}")
	public ResponseDTO<?> getPremiumUsersById(@PathVariable int id) {
		System.out.println("in get al users");
		return new ResponseDTO<>(HttpStatus.OK, "Fetching user list successfully", userService.isPremium(id));
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
	
	
	
	
	
}
