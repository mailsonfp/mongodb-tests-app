package com.mongodb.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.mapper.components.CommentMapper;
import com.mongodb.api.mapper.components.PostMapper;
import com.mongodb.api.mapper.dto.input.CommentInputDto;
import com.mongodb.api.mapper.dto.input.PostInputDto;
import com.mongodb.api.mapper.dto.output.CommentOutputDto;
import com.mongodb.api.mapper.dto.output.PostCommentOutputDto;
import com.mongodb.api.mapper.dto.output.PostOutputDto;
import com.mongodb.domain.model.Comment;
import com.mongodb.domain.model.Post;
import com.mongodb.domain.service.CommentService;
import com.mongodb.domain.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	CommentMapper commentMapper;
	
	@GetMapping
	public List<PostOutputDto> listAll(){
		return postMapper.toCollectionModel(postService.listAll());
	}
	
	@GetMapping(path = "{postCode}")
	public PostOutputDto getByPostCode(@PathVariable String postCode){	
		return postMapper.toModel(postService.findByCode(postCode));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostOutputDto save(@RequestBody PostInputDto post) {
		var postDomain = postMapper.toDomainObject(post);
		postService.save(postDomain);				
		
		return postMapper.toModel(postDomain);
	}
	
	@GetMapping(path = "{postCode}/comments")
	public List<CommentOutputDto> listComments(@PathVariable String postCode){
		Post post = postService.findByCode(postCode);
		if(post==null) {
			ResponseEntity.notFound();
		}
		
		return commentMapper.toCollectionModel(commentService.listByPost(post));
	}
	
	@PutMapping(path = "{postCode}/comments")
	public ResponseEntity<PostCommentOutputDto> comment(@PathVariable String postCode, @RequestBody CommentInputDto comment){
		Post post = postService.findByCode(postCode);
		if(post==null) {
			return ResponseEntity.notFound().build();
		}
		
		Comment commentDomain = commentMapper.toDomainObject(comment);
		
		commentDomain.setPostCode(post.getCode());
		commentService.save(post, commentDomain);
		
		PostOutputDto postDto = postMapper.toModel(post);
		Optional<List<CommentOutputDto>> commentsDto = Optional.of(commentMapper.toCollectionModel(commentService.listByPost(post)));
		
		return ResponseEntity.ok(postMapper.toModelWithComments(postDto, commentsDto.orElse(new ArrayList<>())));
	}
}
