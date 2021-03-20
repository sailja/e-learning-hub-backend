package com.app.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.app.pojos.Role;



public class UserDTO {

	private String name;
	private String email;
	private String password;
	private String phone;
	private String dob;
	private Role role;
	private boolean ispremium;
	
	
	
	
	
	public UserDTO() {
		System.out.println("in user dto");
	}





	public UserDTO(String name, String email, String password, String phone, String dob) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getDob() {
		return dob;
	}


	



	public void setDob(String dob) {
		  //convert String to LocalDate
		this.dob= dob; 
	}





	public Role getRole() {
		return role;
	}





	public void setRole(Role role) {
		this.role = role;
	}





	public boolean isIspremium() {
		return ispremium;
	}





	public void setIspremium(boolean ispremium) {
		this.ispremium = ispremium;
	}





	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone + ", dob="
				+ dob + ", role=" + role + ", ispremium=" + ispremium + "]";
	}





	

	




	
	

}
