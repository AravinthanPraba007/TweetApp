package com.example.tweet.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweet.entity.Tweet;
import com.example.tweet.model.PublicTweet;
import com.example.tweet.repository.TweetRepo;
import com.example.tweet.request.PostTweetRequest;

@Service
public class TweetHelper {
	
	@Autowired
	TweetRepo tweetRepo;

	public boolean postTweet(PostTweetRequest request) {
		Tweet tweet = new Tweet();
		tweet.setEmailId(request.getEmailID());
		tweet.setTweet(request.getTweetContent());
		Tweet savedTweet = tweetRepo.save(tweet);
		if(savedTweet == null)
			return false;
		return true;
	}
	
	public List<String> viewMyTweets(String emailId) {
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets = tweetRepo.findByEmailId(emailId);
//		Next filter the tweet list 
		return null;
		
	}
	
	public List<PublicTweet> viewAllTweets() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets = tweetRepo.findAll();
//		Next filter the list to pulictweet list
		return null;
		
	}
}
