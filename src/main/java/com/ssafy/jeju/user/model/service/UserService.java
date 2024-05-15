package com.ssafy.jeju.user.model.service;

import com.ssafy.jeju.user.model.dto.User;
import com.ssafy.jeju.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

	public User getMyInfoBySecurity() {
		return userMapper.findByEmail(getCurrentUserEmail()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
	}

	public static String getCurrentUserEmail() {
		// SecurityContextHolder에서 현재 인증 정보를 가져옴
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// 인증 정보가 없거나 사용자명이 null인 경우 예외 처리
		if (authentication == null || authentication.getName() == null) {
			throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
		}
		return authentication.getName();
	}
}

