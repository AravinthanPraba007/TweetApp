package com.example.tweet.request;

public class PostTweetRequest {

	String emailID;
	String tweetContent;
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getTweetContent() {
		return tweetContent;
	}
	public void setTweetContent(String tweetContent) {
		this.tweetContent = tweetContent;
	}
	
	public PostTweetRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
