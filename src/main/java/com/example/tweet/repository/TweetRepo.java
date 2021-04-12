package com.example.tweet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.tweet.entity.Tweet;

public interface TweetRepo extends MongoRepository<Tweet, String>{

	@Query("{ 'emailID' : ?0 }")
    List<Tweet> findByEmailId(String emailId);
}
