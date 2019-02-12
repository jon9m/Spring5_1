package com.mmk;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 10 meters";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
