package com.mmk;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
