package com.example.tweet.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tweet")
public class Tweet {

	@Id
	private String id;
	private String emailId;
	private String tweet;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String tweetAuthor) {
		this.emailId = tweetAuthor;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweetContent) {
		this.tweet = tweetContent;
	}
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
