package com.biorecruit.rest.post;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.biorecruit.dao.post.PostRepository;
import com.biorecruit.dao.user.UserRepository;
import com.biorecruit.entity.Post;
import com.biorecruit.entity.User;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/post")
public class PostCtrl {
	
	@Autowired
	private PostRepository postResp;

	@Autowired
	private UserRepository userResp;


    @GetMapping("/list")
	public List<Post> ShowPost() {
		return postResp.findAll();
	}
    
    @GetMapping("/{pid}")
    public User ShowUserInfo(@PathVariable Long pid) {
    	User user=postResp.findById(pid).get().getUser();
    	return user;
    }
    
	
    @PostMapping("/write/{id}")
	private void CratePost(@PathVariable Long id,@RequestBody Post postTO) {
		System.out.println(id);
		System.out.println(postTO);
		postTO.setUser(userResp.findById(id).get());
		postResp.save(postTO);
	}

	  
}
