package com.example.tweet.response;

import java.util.List;

import com.example.tweet.model.PublicTweet;

public class ViewAllTweetstResponse extends GeneralResponse{

	List<PublicTweet> tweetList;

	public List<PublicTweet> getTweetList() {
		return tweetList;
	}

	public void setTweetList(List<PublicTweet> tweetList) {
		this.tweetList = tweetList;
	}

	public ViewAllTweetstResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
