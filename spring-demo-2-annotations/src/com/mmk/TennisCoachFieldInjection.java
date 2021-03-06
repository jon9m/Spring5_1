package com.mmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sillyFieldCoach")
public class TennisCoachFieldInjection implements Coach {

	@Autowired
	private FortuneService coachFortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volly";
	}

	@Override
	public String getDailyFortune() {
		return this.coachFortuneService.getFortune();
	}

}