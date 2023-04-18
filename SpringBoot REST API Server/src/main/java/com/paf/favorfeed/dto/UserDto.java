package com.paf.favorfeed.dto;

import java.util.Objects;

public class UserDto {
	
	private Integer id;
    private String username;
    private String email;
    private String name;
    private String userImage;
    
    public UserDto() {
    	
    }
    
	public UserDto(Integer id, String username, String email, String name, String userImage) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.userImage = userImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, userImage, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(userImage, other.userImage) && Objects.equals(username, other.username);
	}
    
	
    
}
