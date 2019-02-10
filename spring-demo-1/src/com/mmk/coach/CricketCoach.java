package com.mmk.coach;

import com.mmk.services.FortuneService;

public class CricketCoach implements Coach {
	private String emailAddress;
	private String team;

	private FortuneService fortuneService;

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Try score 10 at least! " + this.fortuneService.getFortune() + " : " + getEmailAddress() + " : " + getTeam();
	}

	// Getter and setter for fields
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
