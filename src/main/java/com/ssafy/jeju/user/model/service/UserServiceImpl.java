package com.ssafy.jeju.user.model.service;

import com.ssafy.jeju.user.model.dto.User;
import com.ssafy.jeju.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	@Override
	public void createUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public User getUserByUserId(String userId) {
		return userMapper.selectUserByUserId(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.selectAllUsers();
	}

	@Override
	public void updateUser(int id) {
		userMapper.updateUser(id);
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}
}
