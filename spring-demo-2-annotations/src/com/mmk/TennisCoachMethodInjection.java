package com.mmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sillyMethCoach")
public class TennisCoachMethodInjection implements Coach {

	private FortuneService coachFortuneService;

	@Autowired
	public void someSillyMethod(FortuneService coachFortuneService) {
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