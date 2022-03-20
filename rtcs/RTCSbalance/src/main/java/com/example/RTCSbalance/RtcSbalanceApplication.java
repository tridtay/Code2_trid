package com.example.RTCSbalance;

import com.example.RTCSbalance.core.RTCSbalanceRepository;
import com.example.RTCSbalance.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RtcSbalanceApplication {

	@Autowired
	private RTCSbalanceRepository rtcSbalanceRepository;
	@PostConstruct
	public void xyz(){
		Account user = new Account();
		user.setName("rew");
		user.setBalance(500L);
		rtcSbalanceRepository.save(user);

	}

	public static void main(String[] args) {
		SpringApplication.run(RtcSbalanceApplication.class, args);
	}

}
