package com.example.tweet.request;

import java.util.Date;

public class ForgetPasswordRequest {

	String emailId;
	Date dob;
	String newPassword;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public ForgetPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
