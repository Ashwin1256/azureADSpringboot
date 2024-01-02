package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hi")
public class Hello {

	@GetMapping("/welcome")

	public String HelloApplication() {

		return "hello";
	}

	 @GetMapping("/hello")
	 @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public String HelloApplication2() {

		return "hello2";
	}

}
