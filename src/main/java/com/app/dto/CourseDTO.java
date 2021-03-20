package com.app.dto;

public class CourseDTO {

	private String name;
	
	

	public CourseDTO() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public CourseDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseDTO [name=" + name + "]";
	}
	
	
}
