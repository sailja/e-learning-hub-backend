package com.app.service;


import java.util.List;
import java.util.Optional;

import javax.security.auth.Subject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectRepository;
import com.app.dao.TestRepository;
import com.app.dao.UserRepository;
import com.app.dto.QuestionDTO;
import com.app.dto.SubjectDTO;
import com.app.dto.TestDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Questions;
import com.app.pojos.Role;
import com.app.pojos.Subjects;
import com.app.pojos.Test;
import com.app.pojos.User;


@Service
@Transactional // Optional :Add it --- if you want to keep tx open in the service layer
public class TestServiceImpl implements ITestService {
	// dependency : DAO layer i/f
	@Autowired
	private TestRepository testRepo;
	
	@Autowired
	private SubjectRepository subRepo;
	
	@Override
	public Test addTestDetails(TestDTO TestDTO, int Subject_id ) {
		Subjects subjects = subRepo.findById(Subject_id).get();
		List<Test> tList = subjects.getTests();
		Test test = new Test(TestDTO.getName(), TestDTO.getMarksPerQuestion(), TestDTO.isPremium(), TestDTO.getPrice());
		
		subjects.addTest(test);
		tList.add(test);
		return test;
	}
	
	public Test updateTestDetails(int testId,TestDTO testDTO) {
		Test testDetails = testRepo.findById(testId).get();
		System.out.println("Test details"+testDetails);
		BeanUtils.copyProperties(testDTO, testDetails);
		System.out.println("updated details"+testDetails);
		return testDetails;
	}

	@Override
	public List<Test> getTestDetails(int testId) {
		// TODO Auto-generated method stub
		return testRepo.getTestById(testId);
	}



}
