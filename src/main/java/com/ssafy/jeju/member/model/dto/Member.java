package com.ssafy.jeju.member.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member {
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String joinDate;
	public Member(String userId, String userName, String userPassword, String userEmail, String joinDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.joinDate = joinDate;
	}
	
}
