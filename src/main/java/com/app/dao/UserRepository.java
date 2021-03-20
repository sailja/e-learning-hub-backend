package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);
	//method to return one  paricular user details depends on userid
	User findById(int id);
	List<User> findAllByRole(Role role);
	@Query("select u from User u where id=id and u.isPremium=true ")
	User isPremium(@Param("id")int id);
	
	
	
}
