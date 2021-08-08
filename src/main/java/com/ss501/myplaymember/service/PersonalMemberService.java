package com.ss501.myplaymember.service;

import java.util.List;

import com.ss501.myplaymember.domain.member.entity.PersonalMember;

public interface PersonalMemberService {
	
	List<PersonalMember> findAllPersonalMember();
	List<PersonalMember> findAllPersonalMemberById(Long id);
	List<PersonalMember> findAllPersonalMemberByFavoriteType(String favoriteType);	
	PersonalMember savePersonalMember(PersonalMember personalMember);
}
