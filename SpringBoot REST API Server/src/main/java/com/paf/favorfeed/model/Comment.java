package com.paf.favorfeed.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.paf.favorfeed.dto.UserDto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id", column=@Column(name="user_id")),
		@AttributeOverride(name="email", column = @Column(name="user_email"))
	})
	private UserDto user;
	
	private String content;
	
	@Embedded
	@ElementCollection
	private Set<UserDto> likedByUsers = new HashSet<UserDto>();
	
	private LocalDateTime createdAt;

	public Comment(Integer id, UserDto user, String content, Set<UserDto> likedByUsers, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.likedByUsers = likedByUsers;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<UserDto> getLikedByUsers() {
		return likedByUsers;
	}

	public void setLikedByUsers(Set<UserDto> likedByUsers) {
		this.likedByUsers = likedByUsers;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
