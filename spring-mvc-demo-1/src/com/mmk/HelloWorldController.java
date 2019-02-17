package com.mmk;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String thename = request.getParameter("name2");
		thename = "Yo! " + thename.toUpperCase();
		model.addAttribute("message", thename);

		return "helloworld";
	}

	@RequestMapping("/processFormVersion3")
	public String letsShoutDude2(@RequestParam("name3") String name2, Model model) {		
		name2 = "Hey my friend! " + name2.toUpperCase();
		model.addAttribute("message", name2);

		return "helloworld";
	}

}
