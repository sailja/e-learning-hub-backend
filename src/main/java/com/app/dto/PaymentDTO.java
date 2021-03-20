package com.app.dto;

public class PaymentDTO {

	private Integer user_id;
	private Integer test_id;
	private double amount;
	
	
	public PaymentDTO() {
		super();
	}


	public PaymentDTO(Integer user_id, Integer test_id, double amount) {
		super();
		this.user_id = user_id;
		this.test_id = test_id;
		this.amount = amount;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Integer getTest_id() {
		return test_id;
	}


	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "PaymentDTO [user_id=" + user_id + ", test_id=" + test_id + ", amount=" + amount + "]";
	}


	
	
}
