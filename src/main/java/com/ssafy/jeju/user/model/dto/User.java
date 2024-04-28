package com.ssafy.jeju.user.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private java.sql.Timestamp joinDate;
}
