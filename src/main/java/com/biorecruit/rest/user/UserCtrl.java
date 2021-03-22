package com.biorecruit.rest.user;

import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biorecruit.dao.user.UserRepository;
import com.biorecruit.entity.User;
import com.biorecruit.security.JwtTokenProvider;
import com.biorecruit.service.user.UserService;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController("/api/v1/user")
public class UserCtrl {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
    
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private UserService userService;
	
    // 회원가입
    @PostMapping("/join")
    public Long join(@RequestBody User user) {
    	return userService.join(user);
    }
    
    // 판매자 회원 가입
    @PostMapping("/join/seller")
    public Long joinSeller(@RequestBody User user) {
        return userRepository.save(User.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(Collections.singletonList("ROLE_SELLER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }
    
    
    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User member = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        System.out.println(member.getPassword());
        return jwtTokenProvider.createToken(member.getEmail(), member.getRoles());
    }
    @PostMapping("/hello")
    public String hello(@RequestBody User user) {
        return "hellowolrd";
    }

    
    //X-AUTH-TOKEN 을 넣어야 정상적이게 작동한다. 
    @GetMapping("/user/hello")
    public String user(@RequestBody User user) {
        return "www";
    }
    
    @GetMapping("/seller/hello")
    public String seller() {
        return "www";
    }

}
