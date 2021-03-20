package com.app.dto;

public class QuestionDTO {
	private String data;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String Answer;
	 public QuestionDTO() {}
	
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
	
	@Override
	public String toString() {
		return "QuestionDTO [data=" + data + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", Answer=" + Answer + "]";
	}

	public QuestionDTO(String data, String option1, String option2, String option3, String option4,
			String answer) {
		super();
		this.data = data;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		Answer = answer;
	}
	 

}
