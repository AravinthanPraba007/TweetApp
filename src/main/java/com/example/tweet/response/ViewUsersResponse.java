package com.example.tweet.response;

import java.util.List;

import com.example.tweet.model.PublicUser;

public class ViewUsersResponse extends GeneralResponse{

	List<PublicUser> users;

	public List<PublicUser> getUsers() {
		return users;
	}
	public void setUsers(List<PublicUser> users) {
		this.users = users;
	}
	
	public ViewUsersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
