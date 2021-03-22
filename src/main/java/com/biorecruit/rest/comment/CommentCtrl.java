package com.biorecruit.rest.comment;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.biorecruit.dao.comment.CommentRepository;
import com.biorecruit.dao.post.PostRepository;
import com.biorecruit.dao.user.UserRepository;
import com.biorecruit.entity.Comment;
import com.biorecruit.entity.Post;
import com.biorecruit.entity.User;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/comment")
public class CommentCtrl {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
 
	@Autowired
	UserRepository userRepository;


	// Put Update Mapping 
	@PostMapping("/create/{id}/{pid}")
	public Comment createComment(@PathVariable Long id,@PathVariable Long pid,@RequestBody Comment commentTO){
		System.out.println(id);
		Optional<Post> postItem = postRepository.findById(pid);
		Optional<User> userItem = userRepository.findById(id);
		commentTO.setPost(postItem.get());
		commentTO.setUser(userItem.get());
		commentRepository.save(commentTO);
		return commentTO;
	}

	  
}
