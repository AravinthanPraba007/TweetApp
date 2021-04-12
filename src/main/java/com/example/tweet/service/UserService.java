package com.example.tweet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tweet.helper.UserHelper;
import com.example.tweet.model.PublicUser;
import com.example.tweet.request.ForgetPasswordRequest;
import com.example.tweet.request.LoginRequest;
import com.example.tweet.request.RegisterRequest;
import com.example.tweet.request.ResetPasswordRequest;
import com.example.tweet.response.ForgetPasswordResponse;
import com.example.tweet.response.LoginResponse;
import com.example.tweet.response.RegisterResponse;
import com.example.tweet.response.ResetPasswordResponse;
import com.example.tweet.response.ViewUsersResponse;

@Service
public class UserService {
	
	@Autowired
	UserHelper userHelper;
	
	public ResponseEntity<LoginResponse> login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
//		1. Check the email and password 
		if(!userHelper.loginCheck(request)) {
			response.setResponseMessage("Provided email id and password incorrect");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		response.setResponseMessage("Login sucessfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<RegisterResponse> register(RegisterRequest request) {
		RegisterResponse response = new RegisterResponse();
//		1. Check email id present in DB already (helper)
		String emailId = request.getEmailId();
		if(userHelper.emailIdCheck(emailId)) {
			response.setResponseMessage("This email already present in the system");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
//		2. Password check
		String password = request.getPassword();
		if(!userHelper.passwordCheck(password)) {
			response.setResponseMessage("Password is not strong");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
//		3. Store the information to DB
		if(!userHelper.registerUser(request)) {	
			response.setResponseMessage("Account Register unSucessfully");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.setResponseMessage("Account Register sucessfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ForgetPasswordResponse> forgetPassword(ForgetPasswordRequest request) {
		ForgetPasswordResponse response = new ForgetPasswordResponse();
//		1. Check the Date of birth is Correct or not
		String emailID = request.getEmailId();
		Date dob = request.getDob();
		if(!userHelper.dobCheck(emailID, dob)) {
			response.setResponseMessage("Provided Date of birth is incorrect");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
//		2. Store the new password to the DB
		response.setResponseMessage("New password set successfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResetPasswordResponse> resetPassword(ResetPasswordRequest request) {
		ResetPasswordResponse response = new ResetPasswordResponse();
//		1. Check the old the password is correct or not 
		String emailId = request.getEmailId();
		String oldPassword = request.getOldPassword();
		if(!userHelper.oldPasswordCheck(emailId, oldPassword)) {
			response.setResponseMessage("Provided old password is incorrect");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
//		2. Store the new password to the DB
		response.setResponseMessage("New password set successfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ViewUsersResponse> viewAllUsers(){
		ViewUsersResponse response = new ViewUsersResponse();
//		1. Retrieve all the user in the DB
		List<PublicUser> userList = new ArrayList<PublicUser>();
		userList = userHelper.viewUsers();
		response.setUsers(userList);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
