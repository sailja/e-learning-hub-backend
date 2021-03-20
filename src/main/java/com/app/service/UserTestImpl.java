package com.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TestRepository;
import com.app.dao.UserRepository;
import com.app.dto.ResponseDTO;
import com.app.dto.UserTestDTO;
import com.app.pojos.Courses;
import com.app.pojos.Subjects;
import com.app.pojos.Test;
import com.app.pojos.User;

@Service
@Transactional
public class UserTestImpl implements IUserTestService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TestRepository testRepo;
	
	@Override
	public ResponseDTO addUserTest(UserTestDTO userTest) {
		User u = userRepo.findById(userTest.getUserId());
		
		List<Test> test = testRepo.findByNameIn(userTest.getTestName());
		boolean added=u.getTests().addAll(test);
		String sts = "Tests not added as no changes exist";
		if(added)
			sts="Tests added in User";
		return new ResponseDTO(sts);
		
	}

	

	@Override
	public Set<Test> getUserTest(int UserId) {
		
		 User u = userRepo.findById(UserId);
	        Set<Test> t = u.getTests();
			System.out.println("tests :"+t);
			return t;
	}

}
