package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subjects")
public class Subjects extends BaseEntity {
	
	@NotBlank(message = "Subject name can't be blank")
	@Column(nullable = false, unique = true,length = 20)
	private String name;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "subjects")
	@JsonIgnoreProperties("subjects")
	private Set<Courses> courses=new HashSet<>();
	
	@OneToMany(mappedBy = "selectedNotes", cascade = CascadeType.ALL,orphanRemoval = true /*fetch = FetchType.EAGER */)
	private List<Notes> notes=new ArrayList<>();
	
	@OneToMany(mappedBy = "subjectTests", cascade = CascadeType.ALL,orphanRemoval = true ,fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private List<Test> tests=new ArrayList<>();

	public Subjects() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Subjects(@NotBlank(message = "Subject name can't be blank") String name, Set<Courses> courses,
			List<Notes> notes, List<Test> tests) {
		super();
		this.name = name;
		this.courses = courses;
		this.notes = notes;
		this.tests = tests;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<Courses> getCourses() {
		return courses;
	}

	@JsonIgnore
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
	@JsonIgnore
	public List<Notes> getNotes() {
		return notes;
	}

	
	@JsonIgnore
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	@JsonIgnore
	public List<Test> getTests() {
		return tests;
	}
	@JsonIgnore
	public void setTests(List<Test> tests) {
		this.tests = tests;
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
	     Subjects other = (Subjects) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public void addNotes(Notes n)
	{
		notes.add(n);
		n.setSelectedNotes(this);
	}
	public void removeNotes(Notes n)
	{
		notes.remove(n);
		n.setSelectedNotes(null);
	}	
	
	
	public void addTest(Test t)
	{
		tests.add(t);
		t.setSubjectTests(this);
	}
	public void removeTest(Test t)
	{
		tests.remove(t);
		t.setSubjectTests(null);
	}	
	

}
