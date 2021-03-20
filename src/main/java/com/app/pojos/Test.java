package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tests")
public class Test extends BaseEntity{
	
	@NotBlank(message = "Test name can't be blank")
	@Column(nullable = false, unique = true,length = 20)
	private String name;
	
	@Column(nullable = false,length = 20)
	private int marksPerQuestion;
	
	private boolean isPremium;
	private double price;
	
	public Test(){}
	
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "subject_id",nullable = false)// to specify name of FK column n adds NOT NULL constraint
		private Subjects subjectTests;

	 @OneToMany(mappedBy = "testQuestions", cascade = CascadeType.ALL,orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	@Fetch(FetchMode.JOIN)
	 private List<Questions> questions=new ArrayList<>();
	 
	 @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "tests")
		@JsonIgnoreProperties("tests")
		private Set<User> users=new HashSet<>();
	 
	 

	public Test(String name, int marksPerQuestion, boolean isPremium,
			double price) {
		super();
		this.name = name;
		this.marksPerQuestion = marksPerQuestion;
		this.isPremium = isPremium;
		this.price = price;
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

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@JsonIgnore
	public Subjects getSubjectTests() {
		return subjectTests;
	}
	@JsonIgnore
	public void setSubjectTests(Subjects subjectTests) {
		this.subjectTests = subjectTests;
	}

	@JsonIgnore
	public List<Questions> getQuestions() {
		return questions;
	}

	@JsonIgnore
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}

	@JsonIgnore
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	     Test other = (Test) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	 
	public void addQuestion(Questions q)
	{
		questions.add(q);
		q.setTestQuestions(this);
	}
	public void removeQuestion(Questions q)
	{
		questions.remove(q);
		q.setTestQuestions(null);
	}	

}
