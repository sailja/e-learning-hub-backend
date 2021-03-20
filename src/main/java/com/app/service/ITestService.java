package com.app.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.app.dto.SubjectDTO;
import com.app.dto.TestDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Subjects;
import com.app.pojos.Test;
import com.app.pojos.User;

public interface ITestService {
	
	Test addTestDetails(TestDTO testDTO, int subjectId );
	public Test updateTestDetails(int testId,TestDTO test);
	
	public List<Test> getTestDetails(int testId);
 	
}
