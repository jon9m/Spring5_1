package com.mmk.coach;

import com.mmk.services.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k, " + this.fortuneService.getFortune();
	}
	
	public void coachInitMethod() {		
		System.out.println("---------- Inside coach init mehtod ----------");
	}
	
	public void coachDestroyMethod() {
		System.out.println("---------- Inside coach destroy mehtod ----------");
	}

}
