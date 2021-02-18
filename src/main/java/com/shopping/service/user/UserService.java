//package com.shopping.service.user;
//
//import lombok.RequiredArgsConstructor;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.shopping.dao.user.UserRepository;
//import com.shopping.entity.User;
//
//@Service
//public class UserService  {
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public Long join(@RequestBody User user) {
//        return userRepository.save(User.builder()
//                .email(user.getEmail())
//                .name(user.getName())
//                .password(passwordEncoder.encode(user.getPassword()))
//                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
//                .build()).getId();
//    }
//}