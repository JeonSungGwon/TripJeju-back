package com.ssafy.jeju.member.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.jeju.member.model.dto.Member;

@Mapper
public interface MemberMapper {
	void joinMember(Member member);
	Member loginMember(Map<String, String> map) throws SQLException;
	void updateMember(Member member) throws SQLException;
	void deleteMember(String userId) throws SQLException;
	
}
