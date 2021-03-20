package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectRepository;
import com.app.dto.SubjectDTO;
import com.app.pojos.Subjects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectRepository;
import com.app.dto.SubjectDTO;
import com.app.pojos.Role;
import com.app.pojos.Subjects;

@Service
@Transactional // Optional :Add it --- 
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	
	
	
	public Subjects updateSubjectDetails(int subjectId,SubjectDTO subjectDTO) {
		Subjects subjectDetails = subjectRepo.findById(subjectId).get();
		System.out.println("subject details"+subjectDetails);
		BeanUtils.copyProperties(subjectDTO, subjectDetails);
		System.out.println("updated details"+subjectDetails);
		return subjectDetails;
	}


	

}
