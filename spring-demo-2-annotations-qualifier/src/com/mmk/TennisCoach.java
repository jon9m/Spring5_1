package com.mmk;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
@Scope("singleton")
public class TennisCoach implements Coach {

	private FortuneService coachFortuneService;

	@Autowired
//	@Qualifier("") //disallowed here	
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService coachFortuneService) {
		super();
		this.coachFortuneService = coachFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volly";
	}

	@Override
	public String getDailyFortune() {
		return this.coachFortuneService.getFortune();
	}

	@PostConstruct
	public void postConstructMethod() {
		System.out.println("Post-construct method is called");
	}

	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("Pre-destroyMethod method is called");
	}

}