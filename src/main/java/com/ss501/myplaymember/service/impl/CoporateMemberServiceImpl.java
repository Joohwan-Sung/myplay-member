package com.ss501.myplaymember.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ss501.myplaymember.domain.member.entity.CoporateMember;
import com.ss501.myplaymember.domain.member.repository.CoporateMemberRepository;
import com.ss501.myplaymember.service.CoporateMemberService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoporateMemberServiceImpl implements CoporateMemberService{
	
	private final CoporateMemberRepository coporateMemberRepository;
	private static final Logger log = LoggerFactory.getLogger(CoporateMemberServiceImpl.class);

	
	@Override
	public List<CoporateMember> findAllCoporateMember() {		                        
		
		List<CoporateMember> response = null;
		
		try {
			response = coporateMemberRepository.findAll();
			log.info("findAllCoporateMember(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllCoporateMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public List<CoporateMember> findAllCoporateMemberById(Long id) {		                 
		
		List<CoporateMember> response = null;
		
		try {
			response = coporateMemberRepository.findAllCoporateMemberById(id);
			log.info("findAllCoporateMemberById(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllCoporateMemberById(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@Transactional
	public CoporateMember saveCoporateMember(CoporateMember coporateMember) {

		CoporateMember response = null;
		
		try {
			response = coporateMemberRepository.save(coporateMember);
			log.info("saveCoporateMember(Response) : " + response.toString());
		} catch(Exception e) {
			log.info("saveCoporateMember(Exception) : " + e.getMessage());
		}
		
		
		return response;
	}

}
