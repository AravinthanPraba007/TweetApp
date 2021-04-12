package com.example.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tweet.helper.TweetHelper;
import com.example.tweet.helper.UserHelper;
import com.example.tweet.model.PublicTweet;
import com.example.tweet.request.PostTweetRequest;
import com.example.tweet.request.ViewMyTweetstRequest;
import com.example.tweet.response.PostTweetResponse;
import com.example.tweet.response.ViewAllTweetstResponse;
import com.example.tweet.response.ViewMyTweetstResponse;

@Service
public class TweetService {
	
	@Autowired
	TweetHelper tweetHelper;
	
	@Autowired
	UserHelper userHelper;
	
	public ResponseEntity<PostTweetResponse> postTweet(PostTweetRequest request) {
		PostTweetResponse response = new PostTweetResponse();
//		1. Check the email is present or not  (helper)
		String emailId = request.getEmailID();
		if(userHelper.emailIdCheck(emailId)) {
			response.setResponseMessage("This user is not registered");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
//		2. Post the tweet to db
		if(tweetHelper.postTweet(request)) {
			response.setResponseMessage("Tweet not posted successfully,Try Again");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setResponseMessage("Tweet posted sucessfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ViewMyTweetstResponse> viewMyTweets(ViewMyTweetstRequest request) {
		ViewMyTweetstResponse response = new ViewMyTweetstResponse();
//		1. Get the tweets for the user email id
		String emailId = request.getEmailId();
		if(userHelper.emailIdCheck(emailId)) {
			response.setResponseMessage("This user is not registered");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		List<String> tweetList = new ArrayList<String>();
		tweetList = tweetHelper.viewMyTweets(emailId);
		response.setTweetList(tweetList);
		response.setResponseMessage("Retrived user tweets sucessfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ViewAllTweetstResponse> viewAllTweets() {
		ViewAllTweetstResponse response = new ViewAllTweetstResponse();
//		1. retrieve all tweets
		List<PublicTweet> tweetList = new ArrayList<PublicTweet>();
		tweetList = tweetHelper.viewAllTweets();
		response.setTweetList(tweetList);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
