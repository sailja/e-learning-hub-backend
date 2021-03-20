package com.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Subjects;
import com.app.pojos.Courses;
import com.app.pojos.Questions;
import com.app.pojos.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
	
	@Query("select t from Test t where subject_id=:id")
	List<Test> getTestById(@Param("id")int id);
	
	@Query("select distinct t from Test t left outer join fetch t.users")
	List<Test> getAllTest();
	Optional<Test> findByName(String name);
	List<Test>findByNameIn(Set<String> testName);
	

}
