package com.ss501.myplaymember;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.ss501.myplaymember.app.config.kafka.KafkaProcessor;



@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
public class MyplayMemberApplication {

	public static ApplicationContext applicationContext;
	private static final Logger log = LoggerFactory.getLogger(MyplayMemberApplication.class);
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MyplayMemberApplication.class, args);
		
		log.info("MyplayMemberApplication(ApplicationContext) : " + "App started successfully.");
	}

}
