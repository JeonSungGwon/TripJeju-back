package com.ssafy.jeju.user.model.dto;

import com.ssafy.jeju.user.model.Role;
import com.ssafy.jeju.user.model.SocialType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private Long id;
	private String email; // 이메일
	private String password; // 비밀번호
	private String nickname; // 닉네임
	private String imageUrl; // 프로필 이미지
	private int age;
	private String city; // 사는 도시
	private Role role = Role.USER;
	private SocialType socialType; // KAKAO, NAVER, GOOGLE
	private String socialId; // 로그인한 소셜 타입의 식별자 값 (일반 로그인인 경우 null)
	private String refreshToken; // 리프레시 토큰

	public void updateRefreshToken(String updateRefreshToken) {
		this.refreshToken = updateRefreshToken;
	}
}

