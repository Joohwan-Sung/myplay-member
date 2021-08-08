package com.ss501.myplaymember.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ss501.myplaymember.domain.member.entity.PersonalMember;
import com.ss501.myplaymember.domain.member.repository.PersonalMemberRepository;
import com.ss501.myplaymember.service.PersonalMemberService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonalMemberServiceImpl implements PersonalMemberService {
	
	private final PersonalMemberRepository personalMemberRepository;
	private static final Logger log = LoggerFactory.getLogger(PersonalMemberServiceImpl.class);
	
	@Override
	public List<PersonalMember> findAllPersonalMember() {		                        
	
		List<PersonalMember> response = null;
		try {
			response = personalMemberRepository.findAll();
			log.info("findAllPersonalMember(Response) : " + response.toString());
		}catch (Exception e) {
			log.info("findAllPersonalMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public List<PersonalMember> findAllPersonalMemberById(Long id) {		                        

		List<PersonalMember> response = null;
		
		try {
			response = personalMemberRepository.findAllPersonalMemberById(id);
			log.info("findAllPersonalMemberById(Response) : " + response.toString());
		}catch (Exception e) {
			log.info("findAllPersonalMemberById(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public List<PersonalMember> findAllPersonalMemberByFavoriteType(String favoriteType) {
		
		List<PersonalMember> response = null;
		
		try {
			response = personalMemberRepository.findAllPersonalMemberByFavoriteType(favoriteType);
			log.info("findAllPersonalMemberByFavoriteType(Response) : " + response.toString());
		}catch (Exception e) {
			log.info("findAllPersonalMemberByFavoriteType(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@Transactional
	public PersonalMember savePersonalMember(PersonalMember personalMember) {
		
		PersonalMember response = null;
		
		try {
			response = personalMemberRepository.save(personalMember);
			log.info("savePersonalMember(Response) : " + response.toString());
		} catch(Exception e) {
			log.info("savePersonalMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}
}
