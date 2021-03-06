package com.mongodb.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.domain.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	Optional<Post> findByCode(String code);
}
