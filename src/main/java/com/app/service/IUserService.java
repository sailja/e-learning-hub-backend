package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.UserDTO;
import com.app.pojos.Role;
import com.app.pojos.User;

public interface IUserService {
	List<User> getAllusers();
	User addUserDetails(UserDTO user);
	public User authenticateUser(String email,String password);
	void deleteUserDetails(int userId);
	public User updateEmployeeDetails(int userId,UserDTO userDTO);
	List<User> findAllByRole(Role role);
	User getUserDetails(int userId);
	public 	User updateUserDetails(int userId,UserDTO userDTO);
	User isPremium(int id);
}
