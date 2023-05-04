package com.paf.favorfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paf.favorfeed.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
