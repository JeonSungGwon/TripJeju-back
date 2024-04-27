package com.ssafy.jeju.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.jeju.member.model.dto.Member;

public interface MemberService {
	void joinMember(Member member);
	Member loginMember(Map<String, String> map) throws SQLException;
	void updateMember(Member member) throws SQLException;
	void deleteMember(String userId) throws SQLException;
}
