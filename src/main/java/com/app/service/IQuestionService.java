package com.app.service;

import java.util.List;

import com.app.dto.QuestionDTO;
import com.app.pojos.Questions;

public interface IQuestionService {
public List<Questions> getquestionsByTestId(int id);
//public Questions addNewQuestion(Questions question);
Questions QuestionDetails(QuestionDTO questionDTO);
Questions addNewQuestion(QuestionDTO QuestionDTO, int testID);
Questions updateQuestion(int id,QuestionDTO questionDto);

}
