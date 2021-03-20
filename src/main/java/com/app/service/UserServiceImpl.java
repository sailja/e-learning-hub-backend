package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.dto.UserDTO;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional // Optional :Add it --- if you want to keep tx open in the service layer
public class UserServiceImpl implements IUserService {
	// dependency : DAO layer i/f
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllusers() {
		return userRepo.findAll();

	}
	
	@Override
	public User addUserDetails(UserDTO userDTO) {
		
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		System.out.println("add user src : " + userDTO);
		System.out.println(user);
		
		return userRepo.save(user);
	}

	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		
		return userRepo.findByEmailAndPassword(email, password);
		}
	@Override
	public void deleteUserDetails(int userId) {
		 User user = userRepo.findById(userId);
		 			if(user.getRole().equals(Role.EMPLOYEE))
									userRepo.deleteById(userId);
								else
									System.out.println("invalid employee");
								
          
	}
	public User updateEmployeeDetails(int userId,UserDTO userDTO) {
		User userDetails = userRepo.findById(userId);
		System.out.println("user details"+userDetails);
		BeanUtils.copyProperties(userDTO, userDetails, "userName","password");
		System.out.println("updated details"+userDetails);
		return userDetails;
	}
	@Override
	public List<User> findAllByRole(Role role) {
			return (List<User>) userRepo.findAllByRole(role);
	}

	@Override
	public User getUserDetails(int userId) {
		User userdetail = userRepo.findById(userId);
		return userdetail;
	}

	
	@Override
	public User isPremium(int id) {
		User user;
		System.out.println(id);
		System.out.println(userRepo.isPremium(id));
		return  userRepo.isPremium(id);
	}
	public User updateUserDetails(int userId,UserDTO userDTO) {
		User userDetails = userRepo.findById(userId);
		System.out.println("user details"+userDetails);
		BeanUtils.copyProperties(userDTO, userDetails, "userName","password");
		System.out.println("updated details"+userDetails);
		return userDetails;
	}


	
	

}
