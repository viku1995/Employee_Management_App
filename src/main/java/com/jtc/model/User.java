package com.jtc.model;

public class User {
	
	private long userId;
    private String password;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
}
