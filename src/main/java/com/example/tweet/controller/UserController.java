package com.example.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweet.request.ForgetPasswordRequest;
import com.example.tweet.request.LoginRequest;
import com.example.tweet.request.RegisterRequest;
import com.example.tweet.request.ResetPasswordRequest;
import com.example.tweet.response.ForgetPasswordResponse;
import com.example.tweet.response.LoginResponse;
import com.example.tweet.response.RegisterResponse;
import com.example.tweet.response.ResetPasswordResponse;
import com.example.tweet.response.ViewUsersResponse;
import com.example.tweet.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userSevice;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(LoginRequest request) {
		return userSevice.login(request);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(RegisterRequest request) {
		return userSevice.register(request);
		
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<ForgetPasswordResponse> forgetPassword(ForgetPasswordRequest request) {
		return userSevice.forgetPassword(request);
		
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<ResetPasswordResponse> resetPassword(ResetPasswordRequest request) {
		return userSevice.resetPassword(request);
		
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<ViewUsersResponse> viewAllUsers(){
		return userSevice.viewAllUsers();
		
	}
	
}
