package com.ssafy.jeju.user.controller;

import com.ssafy.jeju.user.model.dto.User;
import com.ssafy.jeju.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/member/index")
    public void re(){
        System.out.println("avc");
    }

    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }

    @GetMapping("/myInfo")
    public ResponseEntity<User> myInfo() {
        User myInfoBySecurity = userService.getMyInfoBySecurity();
        return ResponseEntity.ok((myInfoBySecurity));
    }
}
