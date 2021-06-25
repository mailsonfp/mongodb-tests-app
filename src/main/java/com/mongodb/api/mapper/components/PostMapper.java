package com.mongodb.api.mapper.components;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.api.mapper.dto.input.PostInputDto;
import com.mongodb.api.mapper.dto.output.CommentOutputDto;
import com.mongodb.api.mapper.dto.output.PostCommentOutputDto;
import com.mongodb.api.mapper.dto.output.PostOutputDto;
import com.mongodb.domain.model.Post;

@Component
public class PostMapper {

	@Autowired
	private ModelMapper mapper;
	
	public Post toDomainObject(PostInputDto postInput) {
		 return mapper.map(postInput, Post.class);
	}
   
	public void copyToDomainObject(PostInputDto postModel, Post post) {		        
		 mapper.map(postModel, post);
	}
	 
	public PostOutputDto toModel(Post post) {
		return mapper.map(post, PostOutputDto.class);
	}
	
	public List<PostOutputDto> toCollectionModel(List<Post> posts){
		return posts.stream()
				.map(post -> toModel(post))
				.collect(Collectors.toList());
	}
	
	public PostCommentOutputDto toModelWithComments(PostOutputDto post, List<CommentOutputDto> comments) {
		PostCommentOutputDto postComments = new PostCommentOutputDto();
		postComments.setPost(post);
		postComments.setComments(comments);
		
		return postComments;
	}
}
