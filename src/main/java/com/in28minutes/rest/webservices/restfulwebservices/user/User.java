package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
	private Integer userID;
	private String name;
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
