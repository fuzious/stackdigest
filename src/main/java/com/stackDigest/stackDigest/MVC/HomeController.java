package com.stackDigest.stackDigest.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String home() {
		System.out.println("hi");
		return "index";
	}
}
