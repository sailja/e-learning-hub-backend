package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	
@NotBlank(message = "User name can't blank")
@Column(nullable = false, unique = true,length = 20)
private String name;

@Column(length = 20,unique = true)
private String email;

@Column(length = 20,nullable=false)
private String password;

//@NotNull(message = "dob is required")
//@Past
private String dob;

@Enumerated(EnumType.STRING)
private Role role;
private Boolean isPremium;


@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
@JoinTable(name = "user_test", joinColumns=
@JoinColumn(name = "user_id"),
inverseJoinColumns = @JoinColumn(name = "test_id"))

@JsonIgnoreProperties("users")
private Set<Test> tests =new HashSet<Test>();


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public Boolean getIsPremium() {
	return isPremium;
}

public void setIsPremium(Boolean isPremium) {
	this.isPremium = isPremium;
}

@JsonIgnore
public Set<Test> getTests() {
	return tests;
}

@JsonIgnore
public void setTests(Set<Test> tests) {
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
	User other = (User) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}



}
