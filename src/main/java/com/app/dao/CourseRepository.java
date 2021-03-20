package com.app.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.security.auth.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Courses;
import com.app.pojos.Subjects;

public interface CourseRepository extends JpaRepository<Courses, Integer> {
	//Courses findByName(String name);

	@Query("select distinct c from Courses c left outer join fetch c.subjects")
	List<Courses>getAllCourses();
	@Query("select  c from Courses c left outer join fetch c.subjects where c.name=:nm")
	Optional<Courses> findByName(@Param("nm") String name);

	
}
