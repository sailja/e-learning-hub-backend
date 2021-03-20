package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Question can't be blank")
	@Column(nullable = false, unique = true,length = 500)
	private String data;
	
	@NotBlank(message = "option can't be blank")
	@Column(nullable = false,length = 20)
	private String option1;
	@NotBlank(message = "option can't be blank")
	@Column(nullable = false,length = 20)
	private String option2;
	@NotBlank(message = "option can't be blank")
	@Column(nullable = false,length = 20)
	private String option3;
	@NotBlank(message = "option can't be blank")
	@Column(nullable = false,length = 20)
	private String option4;
	
	@NotBlank(message = "Answer can't be blank")
	@Column(nullable = false,length = 20)
	private String Answer;
	
	 @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "test_id",nullable = false)// to specify name of FK column n adds NOT NULL constraint
		@Fetch(FetchMode.JOIN)
	
	 private Test testQuestions;

	
	 
	 public Questions(){}
	public Questions(String data,String option1,String option2,String option3, String option4,String answer) {
		super();
		this.data = data;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		Answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	@JsonIgnore
	public Test getTestQuestions() {
		return testQuestions;
	}
	
	@JsonIgnore
	public void setTestQuestions(Test testQuestions) {
		this.testQuestions = testQuestions;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", data=" + data + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", Answer=" + Answer + ", testQuestions=" + testQuestions + "]";
	}
	 
	 

	
}
