package com.ss501.myplaymember.adapter;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss501.myplaymember.app.config.kafka.KafkaProcessor;
import com.ss501.myplaymember.domain.member.entity.PersonalMember;
import com.ss501.myplaymember.domain.member.event.ReservationCanceled;
import com.ss501.myplaymember.domain.member.event.ReservationMade;
import com.ss501.myplaymember.domain.member.repository.PersonalMemberRepository;

@Service
public class PolicyHandler{
	
	@Autowired
    PersonalMemberRepository personalMemberRepository;
	private static final Logger log = LoggerFactory.getLogger(PolicyHandler.class);
		
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){
    	log.info("onStringEventListener(eventString) : " + eventString);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        ReservationMade reservationMade = null;
        ReservationCanceled reservationCanceled = null;
        
        try {
        	reservationMade = objectMapper.readValue(eventString, ReservationMade.class);
        	reservationCanceled = objectMapper.readValue(eventString, ReservationCanceled.class);
        	        	      	
        	if(reservationMade.isMe()) {
        		log.info("onStringEventListener(ReservationMade) : " + eventString);
        		
        		Optional<PersonalMember> personalMemberOptional = personalMemberRepository.findById(reservationMade.getApplicantId());
        		PersonalMember personalMember = personalMemberOptional.get();
        		
        		log.info("onStringEventListener(ReservationMade : personalMember) : " + personalMember.toString());
        		
        		personalMember.setMileage(personalMember.getMileage() + 10L);
        		personalMemberRepository.save(personalMember);
        		
        	} else if(reservationCanceled.isMe()) {
        		log.info("onStringEventListener(ReservationCanceled) : " + eventString);
        		
        		Optional<PersonalMember> personalMemberOptional = personalMemberRepository.findById(reservationMade.getApplicantId());
        		PersonalMember personalMember = personalMemberOptional.get();
        		
        		log.info("onStringEventListener(ReservationCanceled : personalMember) : " + personalMember.toString());
        		
        		if(personalMember.getMileage() > 10L) {
        			personalMember.setPoint(personalMember.getMileage() - 10L);
        		} else {
        			personalMember.setMileage(0L);
        		}
        		personalMemberRepository.save(personalMember);
        	}
        	
        }catch (Exception e){
        	log.info("onStringEventListener(Exception) : " + e.getMessage());
        }
    }
}