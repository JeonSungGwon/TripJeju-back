package com.ssafy.jeju.member.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jeju.member.model.dto.Member;
import com.ssafy.jeju.member.model.mapper.MemberMapper;

@RestController
@RequestMapping("/user")
public class MemberController {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinMember(@RequestBody Member member) {
        try {
            memberMapper.joinMember(member);
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Member> loginMember(@RequestParam("userId") String userId, @RequestParam("userPassword") String userPassword) {
        System.out.println("askdnsad");
    	Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("userPassword", userPassword);
        System.out.println(map);
        try {
            Member member = memberMapper.loginMember(map);
            
            if (member != null) {
                return ResponseEntity.ok(member);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateMember(@RequestBody Member member) {
        try {
            memberMapper.updateMember(member);
            return ResponseEntity.ok("회원정보 수정이 완료되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원정보 수정에 실패했습니다.");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestParam String userId) {
        try {
            memberMapper.deleteMember(userId);
            return ResponseEntity.ok("회원정보 삭제가 완료되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원정보 삭제에 실패했습니다.");
        }
    }
}
