package com.app.service;

import java.util.Set;

import com.app.dto.ResponseDTO;
import com.app.dto.UserTestDTO;
import com.app.pojos.Test;

public interface IUserTestService {
	
	ResponseDTO addUserTest(UserTestDTO userTest);
	
	Set<Test> getUserTest(int UserId);

}
