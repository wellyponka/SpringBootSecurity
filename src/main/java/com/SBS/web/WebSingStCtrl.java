package com.SBS.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class WebSingStCtrl {

	@RequestMapping(value = "/WebLoginSt", method = RequestMethod.GET)
	public String getWebLoginSt(@RequestParam String name) {
		return String.format("Hello %s", name);
	}
}
