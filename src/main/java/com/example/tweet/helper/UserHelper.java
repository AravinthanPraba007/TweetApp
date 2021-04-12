package com.example.tweet.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweet.entity.User;
import com.example.tweet.model.PublicUser;
import com.example.tweet.repository.UserRepo;
import com.example.tweet.request.LoginRequest;
import com.example.tweet.request.RegisterRequest;

@Service
public class UserHelper {
	
	@Autowired
	UserRepo userRepo;
	
	public boolean emailIdPresentInDB(String emailId) {
		User userData = getUserDetailsFromDb(emailId);
		if(userData==null || userData.getEmailId()==null)
			return false;
		return true;
		
	}
	
	public boolean passwordCheck(String password) {
//		Need to do pasword strength check
		return true;
		
	}
	
	public boolean emailIdCheck(String emailId) {
		return emailIdPresentInDB(emailId);
		
	}

	public boolean registerUser(RegisterRequest request) {
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setDob(request.getDob());
		user.setGender(request.getGender());
		user.setEmailId(request.getEmailId());
		user.setPassword(request.getPassword());
		System.out.println(user.toString());
		User insertedUser = userRepo.save(user);
		System.out.println(insertedUser.toString());
		if(insertedUser.getEmailId()!=null)
			return true;
		return false;
	}
	
	public boolean loginCheck(LoginRequest request) {
		User userData = getUserDetailsFromDb(request.getEmailId());
		if(userData==null)
			return false;
		if(userData.getEmailId().equals(request.getEmailId()) && userData.getPassword().equals(request.getPassword()))
			return true;
		return false;
	}
	
	public User getUserDetailsFromDb(String emailId) {
		User userData = userRepo.findByEmailId(emailId);
		return userData;
	}
	
	public boolean dobCheck(String emailId, Date dob) {
		User userData = getUserDetailsFromDb(emailId);
		if(userData==null)
			return false;
		if((dob.toString()).equals((userData.getDob()).toString()))
			return true;
		return false;
		
	}
	
	public boolean oldPasswordCheck(String emailId, String oldPassword) {
		User userData = getUserDetailsFromDb(emailId);
		if(userData==null)
			return false;
		if(oldPassword.equals(userData.getPassword()))
			return true;
		return false;
		
	}
	
	public List<PublicUser> viewUsers() {
		List<User> users = new ArrayList<User>();  
		users = userRepo.findAll();
//		need to filter the name alone to the list
		return null;
		
	}
}
