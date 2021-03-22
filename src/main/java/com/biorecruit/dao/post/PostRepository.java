package com.biorecruit.dao.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biorecruit.entity.Post;
import com.biorecruit.entity.User;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
}
