package com.app.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CourseSubjectDTO {
	
	@NotBlank(message = "Course name cannot be blank")
	private String courseName;
	
	@NotEmpty(message = "Must supply atleast one subject")
	private Set<String> subjectTitles;

	public CourseSubjectDTO() {
		super();
	}

	public CourseSubjectDTO(String courseName,
			Set<String> subjectTitles) {
		super();
		this.courseName = courseName;
		this.subjectTitles = subjectTitles;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<String> getSubjectTitles() {
		return subjectTitles;
	}

	public void setSubjectTitles(Set<String> subjectTitles) {
		this.subjectTitles = subjectTitles;
	}

	@Override
	public String toString() {
		return "CourseSubjectDTO [courseName=" + courseName + ", subjectTitles=" + subjectTitles + "]";
	}
	
	

}
