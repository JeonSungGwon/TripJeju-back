package com.ssafy.jeju.user.model.service;

import com.ssafy.jeju.user.model.dto.User;

import java.util.List;

public interface UserService {
	void createUser(User user);
	User getUserByUserId(String userId);
	List<User> getAllUsers();
	void updateUser(int id);
	void deleteUser(int id);
}
