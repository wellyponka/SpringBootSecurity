package com.SBS.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebSuccessUrl {

	@RequestMapping(value = "/WebSueecssUrl", method = RequestMethod.GET)
	public void goSuccessurl(@RequestParam String type, HttpServletResponse response) {
		try {
			if(type.equals("login"))
				response.sendRedirect("/bye.html");
			else
				response.sendRedirect("/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
