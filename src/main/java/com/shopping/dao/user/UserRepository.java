package com.shopping.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
