package com.mongodb.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.domain.model.Post;
import com.mongodb.domain.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findByCode(String code){
		return postRepository.findByCode(code).orElse(null);
	}
	
	public Post save(Post post) {
		post.setCode(UUID.randomUUID().toString());
		post.setCreationDate(LocalDateTime.now());
		return postRepository.insert(post);
	}

	public List<Post> listAll() {		
		return postRepository.findAll();
	}
}
