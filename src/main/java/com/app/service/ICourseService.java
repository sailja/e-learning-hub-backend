package com.app.service;

import java.util.List;

import com.app.dto.CourseDTO;
import com.app.pojos.Courses;

public interface ICourseService {
	
	public Courses updateCourseDetails(int coursesId,CourseDTO courses);

	
}
