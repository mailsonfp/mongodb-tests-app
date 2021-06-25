package com.mongodb.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.domain.model.Comment;
import com.mongodb.domain.model.Post;
import com.mongodb.domain.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> listByPost(Post post){
		return commentRepository.findByPostCode(post.getCode()).orElse(null);
	}
	
	public Comment save(Post post, Comment comment) {
		comment.setCreationDate(LocalDateTime.now());
		return commentRepository.save(comment);
	}
}
