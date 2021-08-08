package com.ss501.myplaymember.domain.member.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.ss501.myplaymember.MyplayMemberApplication;
import com.ss501.myplaymember.domain.member.enums.FavoriteType;
import com.ss501.myplaymember.domain.member.enums.MemberStatusType;
import com.ss501.myplaymember.domain.member.enums.MembershipLevelType;
import com.ss501.myplaymember.domain.member.event.PersonalMemberChanged;
import com.ss501.myplaymember.domain.member.repository.PersonalMemberRepository;
import com.ss501.myplaymember.domain.member.vo.Address;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table (name = "personal_member")
public class PersonalMember { // extends Member{
	
	private static final Logger log = LoggerFactory.getLogger(PersonalMember.class);
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id ;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "loginPassword")
	private String loginPassword;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "mobile")
	private String  mobile;
	
	@Column (name = "address")
	@Embedded
	private Address address;
	
	@Column (name = "statusType")
	@Enumerated(EnumType.STRING)
	private MemberStatusType statusType;
	
	@Column (name = "levelType")
	@Enumerated(EnumType.STRING)
	private MembershipLevelType levelType;
	
	@Column (name = "favoriteType")
	@Enumerated(EnumType.STRING)
	private FavoriteType favoriteType;
	
	@Column (name = "point")
	private Long point;
	
	@Column (name = "mileage")
	private Long mileage;
	
	@PostUpdate
	private void publishPersonalMemberChanged(){
		log.info("publishPersonalMemberChanged :  event in");
/*		
        PersonalMemberRepository personalMemberRepository = MyplayMemberApplication.applicationContext.getBean(PersonalMemberRepository.class);
        Optional<PersonalMember> personalMemberOptional = personalMemberRepository.findById(this.getId());
        
        if (personalMemberOptional.isPresent()) {
        	
        	PersonalMember personalMember = personalMemberOptional.get();
           	PersonalMemberChanged personalMemberChanged = new PersonalMemberChanged();
	        BeanUtils.copyProperties(personalMember, personalMemberChanged);
	        personalMemberChanged.publish();
            log.info("publishPersonalMemberChanged : event publish");
        }
*/
	}
}
