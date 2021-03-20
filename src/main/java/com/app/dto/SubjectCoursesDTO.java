package com.app.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SubjectCoursesDTO {

	@NotBlank(message = "Subject name can't blank while placing or cancelling order")
	private String courseName;
	
	@NotEmpty(message = "Must supply at least 1 courseName while addding or deleting subject")
	private Set<String> subjectName;

	public SubjectCoursesDTO(String courseName, Set<String> subjectName) {
		super();
		this.courseName = courseName;
		this.subjectName = subjectName;
	}
	
	
	
	
	
}
