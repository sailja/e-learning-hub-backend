package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private int user_id;
	private int test_id;
	private double amount;
	
	
	
	public Payment() {
		super();
	}



	public Payment(Integer id, int user_id, int test_id, double amount) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.test_id = test_id;
		this.amount = amount;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getTest_id() {
		return test_id;
	}



	public void setTest_id(int test_id) {
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
		return "Payment [id=" + id + ", user_id=" + user_id + ", test_id=" + test_id + ", amount=" + amount + "]";
	}

	
	
	
	
}
