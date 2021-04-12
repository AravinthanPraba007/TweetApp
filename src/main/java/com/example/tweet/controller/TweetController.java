package com.example.tweet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweet.request.PostTweetRequest;
import com.example.tweet.request.ViewMyTweetstRequest;
import com.example.tweet.response.PostTweetResponse;
import com.example.tweet.response.ViewAllTweetstResponse;
import com.example.tweet.response.ViewMyTweetstResponse;

@RestController
public class TweetController {
	
	@PostMapping("/tweet")
	public ResponseEntity<PostTweetResponse> postTweet(PostTweetRequest request) {
		return null;
		
	}
	
	@GetMapping("/myTweets")
	public ResponseEntity<ViewMyTweetstResponse> viewMyTweets() {
		return null;
		
	}
	
	@GetMapping("/allTweets/{emailId}")
	public ResponseEntity<ViewAllTweetstResponse> viewAllTweets(@PathVariable String emailId) {
		ViewMyTweetstRequest request = new ViewMyTweetstRequest();
		request .setEmailId(emailId);
		return null;
		
	}

}
