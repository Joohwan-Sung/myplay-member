package com.ss501.myplaymember.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss501.myplaymember.domain.member.entity.CoporateMember;
import com.ss501.myplaymember.service.CoporateMemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class CoporateMemberController {

	private CoporateMemberService coporateMemberService;
	private static final Logger log = LoggerFactory.getLogger(CoporateMemberController.class);
	
	@GetMapping("/playground/members/coporateMemberList")
	public ResponseEntity<List<CoporateMember>> findAllCoporateMember() {

		ResponseEntity<List<CoporateMember>> response = null;

		try {
			response = ResponseEntity.ok().body(coporateMemberService.findAllCoporateMember());
			log.info("findAllCoporateMember(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllCoporateMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/playground/members/coporateMember/{id}")
	public ResponseEntity<List<CoporateMember>> findAllCoporateMemberById(@PathVariable Long id) {
		
		log.info("findAllCoporateMemberById(ID) : " + String.format("%d", id));

		ResponseEntity<List<CoporateMember>> response = null;

		try {
			response = ResponseEntity.ok().body(coporateMemberService.findAllCoporateMemberById(id));
			log.info("findAllCoporateMemberById(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("findAllCoporateMemberById(Exception) : " + e.getMessage());
		}
		
		return response;                                                     
	}
	
	@PostMapping("/playground/members/coporatememberRegister")
	public ResponseEntity<CoporateMember> saveCoporateMember(@RequestBody CoporateMember coporateMember) {

		CoporateMember newCoporateMember = null;
		ResponseEntity<CoporateMember> response = null;

		log.info("saveCoporateMember(Receive) : " + coporateMember.toString());
		
		newCoporateMember = coporateMemberService.saveCoporateMember(coporateMember);

		try {
			response = ResponseEntity.ok().body(newCoporateMember);
			log.info("CoporateMemberController : saveCoporateMember(Response) : " + response.toString());
		} catch (Exception e) {
			log.info("saveCoporateMember(Exception) : " + e.getMessage());
		}
		
		return response;
	}
}
