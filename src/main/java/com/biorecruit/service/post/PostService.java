package com.biorecruit.service.post;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.biorecruit.dao.post.PostRepository;
import com.biorecruit.dao.user.UserRepository;
import com.biorecruit.entity.Post;
import com.biorecruit.entity.User;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {
	
	@Autowired
	private PostRepository postResp;

	@Autowired
	private UserRepository userResp;

	
	public void ShowPost() {
		postResp.findAll();
	}
	
	private void CratePost(Long id,Post postTO) {
		postTO.setUser(userResp.findById(id).get());
		postResp.save(postTO);
	}
	
}
