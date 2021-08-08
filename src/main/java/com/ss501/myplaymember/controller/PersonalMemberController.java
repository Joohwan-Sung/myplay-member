package com.ss501.myplaymember.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss501.myplaymember.domain.member.entity.PersonalMember;
import com.ss501.myplaymember.service.PersonalMemberService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PersonalMemberController {
	
	private PersonalMemberService personalMemberService;
	private static final Logger log = LoggerFactory.getLogger(PersonalMemberController.class);	
		
	@GetMapping("/playground/members/personalMemberList")
	public ResponseEntity<List<PersonalMember>> findAllPersonalMember() {
		
		ResponseEntity<List<PersonalMember>> response = null;

		try {
			response = ResponseEntity.ok().body(personalMemberService.findAllPersonalMember());
			log.info("findAllPersonalMember(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllPersonalMember(Exception) : " + e.getMessage());
		}
		
		return response;		                           
	}
	
	@GetMapping("/playground/members/personalMember/{id}")
	public ResponseEntity<List<PersonalMember>> findAllPersonalMemberById(@PathVariable Long id) {
		
		log.info("findAllPersonalMemberById(ID) : " + String.format("%d", id));

		ResponseEntity<List<PersonalMember>> response = null;

		try {
			response = ResponseEntity.ok().body(personalMemberService.findAllPersonalMemberById(id));
			log.info("findAllCoporateMemberById(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllPersonalMemberById(Exception) : " + e.getMessage());
		}
		
		return response;                                                   
	}
	
	@GetMapping("/playground/members/personalmember/{favoriteType}")
	public ResponseEntity<List<PersonalMember>> findAllPersonalMemberByFavoriteType(@PathVariable String favoriteType) {
		
		log.info("findAllPersonalMemberById(favoriteType) : " + String.format("%s", favoriteType));

		ResponseEntity<List<PersonalMember>> response = null;

		try {
			response = ResponseEntity.ok().body(personalMemberService.findAllPersonalMemberByFavoriteType(favoriteType));	
			log.info("findAllPersonalMemberById(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllPersonalMemberById(Exception) : " + e.getMessage());
		}
		
		return response;	                                                     
	}
	
	@PostMapping("/playground/members/personalmemberRegister")
	public ResponseEntity<PersonalMember> savePersonalMember(@RequestBody PersonalMember personalMember) {
		
		log.info("savePersonalMember(receive) : " + personalMember.toString());

		ResponseEntity<PersonalMember> response = null;

		PersonalMember newPersonalMember = personalMemberService.savePersonalMember(personalMember);

		try {
			response = ResponseEntity.ok().body(newPersonalMember);	
			log.info("savePersonalMember(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("savePersonalMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}

}
