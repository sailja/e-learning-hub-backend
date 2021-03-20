package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.QuestionsRepository;
import com.app.dao.TestRepository;
import com.app.dto.QuestionDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Questions;
import com.app.pojos.Test;
import com.app.pojos.User;

@Service
@Transactional

public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionsRepository quesRepo;
	@Autowired
	private TestRepository testRepo;

	@Override
	public List<Questions> getquestionsByTestId(int id) {

		return quesRepo.getQuestionById(id);
	}

	@Override
	public Questions QuestionDetails(QuestionDTO QuestionDTO) {

		Questions questions = new Questions();

		BeanUtils.copyProperties(QuestionDTO, questions);
		System.out.println("add user src : " + QuestionDTO);
		System.out.println(questions);

		return quesRepo.save(questions);
	}

	@Override
	public Questions addNewQuestion(QuestionDTO QuestionDTO, int testID) {
		Test test = testRepo.findById(testID).get();
		List<Questions> qList = test.getQuestions();
		Questions question = new Questions(QuestionDTO.getData(), QuestionDTO.getOption1(), QuestionDTO.getOption2(),
				QuestionDTO.getOption3(), QuestionDTO.getOption4(), QuestionDTO.getAnswer());
		//question.setTestQuestions(test);
		test.addQuestion(question);
		qList.add(question);
		return question;
	}

	@Override
	public Questions updateQuestion(int id,QuestionDTO questionDto) {
		Questions question=quesRepo.findById(id).get();
		System.out.println("Questions before update"+question);
		BeanUtils.copyProperties(questionDto, question);
		System.out.println("Questions after update"+question);
		return question;
	}

	
}
