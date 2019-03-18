package com.mmk.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + " doing my DB work - add an account");
	}
}
