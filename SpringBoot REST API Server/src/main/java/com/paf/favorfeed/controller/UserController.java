package com.paf.favorfeed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paf.favorfeed.exceptions.UserException;
import com.paf.favorfeed.model.User;
import com.paf.favorfeed.response.MessageResponse;
import com.paf.favorfeed.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException{
		User user = userService.findUserById(id);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> findUserByUsernameHandler(@PathVariable String username) throws UserException{
		User user = userService.findUserByUsername(username);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/follow/{followUserId}")
	public ResponseEntity<MessageResponse> followUserHandler(@PathVariable Integer followUserId) throws UserException{
		
//		MessageResponse res = userService.findUserByUsername(username);
		
		return null;
	}
	
	@PutMapping("/unfollow/{userId}")
	public ResponseEntity<MessageResponse> unFollowUserHandler(@PathVariable Integer userId) throws UserException{
		
//		MessageResponse res = userService.findUserByUsername(username);
		
		return null;
	}
	
	@PutMapping("/req")
	public ResponseEntity<MessageResponse> findUserProfileHandler(@RequestHeader("Authorization") String token) throws UserException{
		
		
		return null;
	}
	
	@GetMapping("/m/{userIds}")
	public ResponseEntity<List<User>> findUserByUserIdsHandler(@PathVariable List<Integer> userIds) throws UserException{
		List<User> users = userService.findUserByIds(userIds);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<User>> searchUserHandler(@RequestParam("q") String query) throws UserException{
		List<User> users = userService.searchUser(query);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	public ResponseEntity<User> updateUserHandler(@RequestHeader("Authorization") String token, @RequestBody User user) throws UserException{
		
//		User updatedUser=userService.updateUserDetails(user, user);
		return null;
	}
}
