package com.app.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseRepository;
import com.app.dao.SubjectRepository;
import com.app.dto.CourseSubjectDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Courses;
import com.app.pojos.Subjects;


@Service
@Transactional
public class CourseSubjectServiceImpl implements ICourseSubjectService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public ResponseDTO addCourseSubject(CourseSubjectDTO courseSubject) {
		
		Courses c = courseRepo.findByName(courseSubject.getCourseName()).get();
		
		List<Subjects> subjects = subjectRepo.findByNameIn(courseSubject.getSubjectTitles());
		boolean added=c.getSubjects().addAll(subjects);
		String sts = "Subjects not added as no changes exist";
		if(added)
			sts="Subjects added in course";
		return new ResponseDTO(sts);
	}

	@Override
	public ResponseDTO removeCourseSubject(CourseSubjectDTO courseSubject) {
		
        Courses c = courseRepo.findByName(courseSubject.getCourseName()).get();
		
		List<Subjects> subjects = subjectRepo.findByNameIn(courseSubject.getSubjectTitles());
		boolean added=c.getSubjects().removeAll(subjects);
		String sts = "Subjects not removed as it does'nt exist";
		if(added)
			sts="Subjects removed in course";
		return new ResponseDTO(sts);
	}
	
	@Override
	public Set<Subjects> getCourseSubject(String courseName) {
		
        Courses c = courseRepo.findByName(courseName).get();
        Set<Subjects> subjects = c.getSubjects();
        
        for(Subjects s : subjects)
        System.out.println(s.toString());
		
		return subjects;
	}

	

}
