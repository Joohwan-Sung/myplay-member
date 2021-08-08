package com.ss501.myplaymember.domain.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss501.myplaymember.domain.member.entity.CoporateMember;

@Repository
public interface CoporateMemberRepository extends JpaRepository<CoporateMember, Long> {
	List<CoporateMember> findAllCoporateMemberById(Long id);
}
