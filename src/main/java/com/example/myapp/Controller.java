package com.example.myapp;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.example.myapp.Register;


@Validated
@RestController
public class Controller {

	private static String INVALID_TOKEN = null;
			
	@RequestMapping(value = "/register")
	public Register RegisterUser(@RequestBody Register register)
	{
		System.out.println("User = " + register);
		return register;
	}
	
	@PostMapping("/register/")
	ResponseEntity<String> student(@RequestHeader Map<String, String> headers, @RequestBody Register register) {
		headers.forEach((key, value) -> {
	        System.out.println("Header "+ key+" = "+ value);
	       
	    });
		System.out.println("User = " + register);
		return ResponseEntity.ok("Headers are read successfully ");
	}
	

	public static String resolveToken(HttpServletRequest headers) {
	    return headers.getHeader("Authorization");
	}
	
	private static String extractToken(String headers) {
	    if (headers != null && headers.startsWith("Bearer ")) {
	        return headers.substring(7);
	    }
	    return INVALID_TOKEN;
	}
}
