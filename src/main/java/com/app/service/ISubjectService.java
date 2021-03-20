package com.app.service;

import java.util.List;

import com.app.dto.SubjectDTO;
import com.app.pojos.Subjects;

public interface ISubjectService {
	
	public Subjects updateSubjectDetails(int subjectsId,SubjectDTO subjects);

	
}
