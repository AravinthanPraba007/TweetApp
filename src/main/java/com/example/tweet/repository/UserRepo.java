package com.example.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tweet.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

	@Query("{ 'emailID' : ?0 }")
    User findByEmailId(String emailId);
	
}
