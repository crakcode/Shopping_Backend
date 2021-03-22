package com.biorecruit.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biorecruit.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
