package com.ss501.myplaymember.domain.member.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalMemberChanged extends AbstractEvent {
	
private String stateMessage = "개인 회원 정보 변경됨";
	
	private Long id ;	
	
	private String name;	
	
	private String email;		
	
	private String mobile;
	
	private String loginPassword;
	
	private String zipCode;		
	
	private String baseAddress;		
	
	private String detailAddress;
	
	private String statusType;	
	
	private String levelType;	
	
	private String favoriteType;
	
	private Long point;	
	
	private Long mileage;
	
	public PersonalMemberChanged() {
		
	}

}
