package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseRepository;
import com.app.dto.CourseDTO;
import com.app.pojos.Role;
import com.app.pojos.Courses;




@Service
@Transactional // Optional :Add it --- 
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	
	
	
	public Courses updateCourseDetails(int courseId,CourseDTO courseDTO) {
		Courses courseDetails = courseRepo.findById(courseId).get();
		System.out.println("course details"+courseDetails);
		BeanUtils.copyProperties(courseDTO, courseDetails);
		System.out.println("updated details"+courseDetails);
		return courseDetails;
	}


	

}
