package com.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping
	public List<PostOutputDto> listAll(){
		return postMapper.toCollectionModel(postService.listAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostOutputDto save(@RequestBody PostInputDto post) {
		var postDomain = postMapper.toDomainObject(post);
		postService.save(postDomain);				
		
		return postMapper.toModel(postDomain);
	}
}
