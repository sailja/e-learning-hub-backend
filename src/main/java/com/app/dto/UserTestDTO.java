package com.app.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserTestDTO {
	
	
	private int userId;
	
	@NotEmpty(message = "Must supply atleast one subject")
	private Set<String> testName;
	
	

	public UserTestDTO() {
		super();
	}



	public UserTestDTO(int userId,Set<String> testName) {
		super();
		this.userId = userId;
		this.testName = testName;
	}



	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Set<String> getTestName() {
		return testName;
	}



	public void setTestName(Set<String> testName) {
		this.testName = testName;
	}



	@Override
	public String toString() {
		return "UserTestDTO [userId=" + userId + ", testName=" + testName + "]";
	}



}
