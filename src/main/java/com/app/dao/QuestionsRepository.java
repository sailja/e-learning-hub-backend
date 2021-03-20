package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
	
	@Query("select q from Questions q where test_id=:id")
	List<Questions> getQuestionById(@Param("id")int id);
	
//	@Query("insert into Questions values")
//	Questions addNewQuestion(@Param("test_id")int test_id);

}
