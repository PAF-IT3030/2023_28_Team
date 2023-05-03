package com.paf.favorfeed.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.favorfeed.exception.PostException;
import com.paf.favorfeed.exception.UserException;
import com.paf.favorfeed.model.Post;
import com.paf.favorfeed.model.User;
import com.paf.favorfeed.response.MessageResponse;
import com.paf.favorfeed.services.PostService;
import com.paf.favorfeed.services.UserService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPostHandler(@RequestBody Post post,@RequestHeader("Authorization") String token) throws UserException{
		
		System.out.println("create post ---- "+post.getCaption());
		
		User user=userService.findUserProfile(token);
		
		Post createdPost = postService.createPost(post, user.getId());
		
		return new ResponseEntity<Post>(createdPost, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/all/{userId}")
	public ResponseEntity<List<Post>> findPostByUserIdHandler(@PathVariable("userId") Integer userId) throws UserException{
		
		List<Post> posts=postService.findPostByUserId(userId);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/following/{userIds}")
	public ResponseEntity<List<Post>> findAllPostByUserIds(@PathVariable("userIds") List<Integer> userIds) throws PostException, UserException {
		
		System.out.println("post userIds ----- "+userIds);
		List<Post> posts=postService.findAllPostByUserIds(userIds);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Post>> findAllPostHandler() throws PostException{
		List<Post> posts=postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws PostException{
		Post post=postService.findePostById(postId);
		
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}
	
	
	@PutMapping("/like/{postId}")
	public ResponseEntity<Post> likePostHandler(@PathVariable("postId") Integer postId, @RequestHeader("Authorization") String token) throws UserException, PostException{
		
		User user=userService.findUserProfile(token);
		
		Post updatedPost=postService.likePost(postId, user.getId());
		
		return new ResponseEntity<Post>(updatedPost,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/unlike/{postId}")
	public ResponseEntity<Post> unLikePostHandler(@PathVariable("postId") Integer postId, @RequestHeader("Authorization") String token) throws UserException, PostException{
		
		User reqUser=userService.findUserProfile(token);
		
		Post updatedPost=postService.unLikePost(postId, reqUser.getId());
		
		return new ResponseEntity<Post>(updatedPost,HttpStatus.OK);
				
	}
	
	
	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<MessageResponse> deletePostHandler(@PathVariable Integer postId, @RequestHeader("Authorization") String token) throws UserException, PostException{
		
		User reqUser=userService.findUserProfile(token);
		
		String message=postService.deletePost(postId, reqUser.getId());
		
		MessageResponse res=new MessageResponse(message);
		
		return new ResponseEntity<MessageResponse> (res, HttpStatus.OK);
		
	}
	
	@PutMapping("/save_post/{postId}")
	public ResponseEntity<MessageResponse> savedPostHandler(@RequestHeader("Authorization")String token,@PathVariable Integer postId) throws UserException, PostException{
		
		User user =userService.findUserProfile(token);
		String message=postService.savedPost(postId, user.getId());
		MessageResponse res=new MessageResponse(message);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PutMapping("/unsave_post/{postId}")
	public ResponseEntity<MessageResponse> unSavedPostHandler(@RequestHeader("Authorization")String token,@PathVariable Integer postId) throws UserException, PostException{
		
		User user =userService.findUserProfile(token);
		String message=postService.unSavePost(postId, user.getId());
		MessageResponse res=new MessageResponse(message);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
