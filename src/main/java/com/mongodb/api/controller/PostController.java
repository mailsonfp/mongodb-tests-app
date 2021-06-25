package com.mongodb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.mapper.components.PostMapper;
import com.mongodb.api.mapper.dto.input.PostInputDto;
import com.mongodb.api.mapper.dto.output.PostOutputDto;
import com.mongodb.domain.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	PostMapper postMapper;
	
	@PostMapping
	public ResponseEntity<PostOutputDto> save(@RequestBody PostInputDto post) {
		var postDomain = postMapper.toDomainObject(post);
		postService.save(postDomain);				
		
		return ResponseEntity.ok(postMapper.toModel(postDomain));
	}
}
