package com.ss501.myplaymember.domain.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss501.myplaymember.domain.member.entity.PersonalMember;

@Repository
public interface PersonalMemberRepository extends JpaRepository<PersonalMember, Long> {
	List<PersonalMember> findAllPersonalMemberById(Long id);
	List<PersonalMember> findAllPersonalMemberByFavoriteType(String favoriteType);	
}
