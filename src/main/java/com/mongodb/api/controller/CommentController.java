package com.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.mapper.components.CommentMapper;
import com.mongodb.api.mapper.dto.output.CommentOutputDto;
import com.mongodb.domain.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	CommentMapper commentMapper;
	
	@GetMapping("/author")
	public List<CommentOutputDto> getByAuthorName(@RequestParam String authorName){
		return commentMapper.toCollectionModel(commentService.listByAuthorName(authorName)); 
	}
}
