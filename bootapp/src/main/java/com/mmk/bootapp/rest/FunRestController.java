package com.mmk.bootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// end point "/"
	@GetMapping
	public String sayHello() {
		return "Time on the server is " + LocalDateTime.now(); 
	}
}
