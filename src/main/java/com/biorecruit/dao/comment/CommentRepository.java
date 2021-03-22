package com.biorecruit.dao.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biorecruit.entity.Comment;
import com.biorecruit.entity.Post;
import com.biorecruit.entity.User;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
