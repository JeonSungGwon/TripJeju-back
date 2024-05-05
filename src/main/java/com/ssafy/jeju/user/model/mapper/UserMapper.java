package com.ssafy.jeju.user.model.mapper;

import com.ssafy.jeju.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
	void insertUser(User user);
	User login(User user);
	User selectUserByUserId(String userId);
	List<User> selectAllUsers();
	void updateUser(int id);
	void deleteUser(int id);
}