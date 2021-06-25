package com.mongodb.domain.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.domain.model.Post;
import com.mongodb.domain.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post save(Post post) {
		post.setCodigo(UUID.randomUUID().toString());
		post.setCreationDate(LocalDateTime.now());
		return postRepository.insert(post);
	}
}
