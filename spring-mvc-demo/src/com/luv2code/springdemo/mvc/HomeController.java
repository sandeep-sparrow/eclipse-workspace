package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// tells spring hey, this is MVC controller which inherits/extends Components
// so that it get's picked up by component scanning
@Controller
public class HomeController {
	
	// handle all types of HTTP request
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
}
