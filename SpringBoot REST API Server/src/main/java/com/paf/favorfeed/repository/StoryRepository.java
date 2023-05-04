package com.paf.favorfeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paf.favorfeed.model.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{
	
	@Query("SELECT s FROM Story s WHERE s.userDto.id = :userId")
    List<Story> findAllStoriesByUserId(@Param("userId") Integer userId);

}
