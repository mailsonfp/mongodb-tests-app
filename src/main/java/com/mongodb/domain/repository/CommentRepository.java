package com.mongodb.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.domain.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
	
	Optional<List<Comment>> findByPostCode(String postCode);

}
