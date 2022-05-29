package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer userID;

	//This is validate that the size of name will be >= 2
	@Size(min=2, message = "Size of NAME must be >= 2")
	private String name;

	//This is validate that the birthDate is always in the past
	@Past(message = "BIRTH DATE must be in the past")
	private Date birthDate;

	public User(Integer userID, String name, Date birthDate) {
		this.userID = userID;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"userID=" + userID +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
