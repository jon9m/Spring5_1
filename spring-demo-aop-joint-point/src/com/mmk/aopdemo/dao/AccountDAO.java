package com.mmk.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount(String tempArg1, String tempArg2) {
		System.out.println(getClass() + " doing my DB work - add an account");
	}
}
