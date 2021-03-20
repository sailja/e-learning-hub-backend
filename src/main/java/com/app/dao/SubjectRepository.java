package com.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {
		
	//Subjects findByName(String name);

		@Query("select distinct s from Subjects s left outer join fetch s.courses")
		List<Subjects> getAllSubjects();
		Optional<Subjects> findByName(String name);
		List<Subjects>findByNameIn(Set<String> subjectTitles);
		


}
