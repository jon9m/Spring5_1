package com.mmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
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

}