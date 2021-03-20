package com.app.dto;



public class TestDTO {

	private String name;
	private int marksPerQuestion;
	private double price;
	private boolean isPremium;
	
	
	public TestDTO() {
		System.out.println("in test dto");
	}


	


	public TestDTO(String name, int marksPerQuestion, double price, boolean isPremium) {
		super();
		this.name = name;
		this.marksPerQuestion = marksPerQuestion;
		this.price = price;
		this.isPremium = isPremium;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public int getMarksPerQuestion() {
		return marksPerQuestion;
	}





	public void setMarksPerQuestion(int marksPerQuestion) {
		this.marksPerQuestion = marksPerQuestion;
	}





	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isPremium() {
		return isPremium;
	}


	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}





	@Override
	public String toString() {
		return "TestDTO [name=" + name + ", marksPerQuestion=" + marksPerQuestion + ", price=" + price + ", isPremium="
				+ isPremium + "]";
	}


	
	
	
	
	
	




	
	

}
