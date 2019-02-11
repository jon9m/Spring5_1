package com.mmk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sillySetterCoach")
public class TennisCoachSetterInjection implements Coach {

	private FortuneService coachFortuneService;

	@Autowired
	@Qualifier("randomFortuneService")
	public void setCoachFortuneService(FortuneService coachFortuneService) {
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