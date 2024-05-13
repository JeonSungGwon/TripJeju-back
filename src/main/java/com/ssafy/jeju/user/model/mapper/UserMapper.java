package com.ssafy.jeju.user.model.mapper;

import com.ssafy.jeju.user.model.SocialType;
import com.ssafy.jeju.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
	Optional<User> findByEmail(String email);
	Optional<User> findByNickname(String nickname);
	Optional<User> findByRefreshToken(String refreshToken);
	Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
	void saveUser(User user);
	void updateUser(User user);
}