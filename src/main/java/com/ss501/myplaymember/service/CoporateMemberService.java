package com.ss501.myplaymember.service;

import java.util.List;

import com.ss501.myplaymember.domain.member.entity.CoporateMember;
import com.ss501.myplaymember.domain.member.entity.PersonalMember;

public interface CoporateMemberService {
	
	List<CoporateMember> findAllCoporateMember();
	List<CoporateMember> findAllCoporateMemberById(Long id);
	CoporateMember saveCoporateMember(CoporateMember coporateMember);
}
