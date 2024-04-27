package com.ssafy.jeju.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.jeju.member.model.dto.Member;
import com.ssafy.jeju.member.model.mapper.MemberMapper;

@Service
public class MemberServicerImpl implements MemberService {

	private final MemberMapper memberMapper;
	
	public MemberServicerImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public void joinMember(Member member) {
		memberMapper.joinMember(member);
	}

	@Override
	public Member loginMember(Map<String, String> map) throws SQLException {
		return memberMapper.loginMember(map);
	}

	@Override
	public void updateMember(Member member) throws SQLException {
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		memberMapper.deleteMember(userId);
	}

}
