package com.example.tweet.response;

import java.util.List;

public class ViewMyTweetstResponse extends GeneralResponse{

	List<String> tweetList;

	public List<String> getTweetList() {
		return tweetList;
	}

	public void setTweetList(List<String> tweetList) {
		this.tweetList = tweetList;
	}

	public ViewMyTweetstResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
