package com.example.tweet.request;

public class ResetPasswordRequest {

	String emailId;
	String oldPassword;
	String newPassword;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public ResetPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
