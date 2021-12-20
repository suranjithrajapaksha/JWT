package com.example.myapp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.myapp.Register;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UserController {
	@PostMapping("user")
	public Register login(@RequestParam("user") String username, @RequestParam("password") String password) {
		
		String token = getJWTToken(username);
		Register register = new Register();
		register.setuser(username);
		register.setToken(token);	
		 System.out.println("jws: "+ token);
		return register;

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		 System.out.println("jws: "+ token);
	

		return "Bearer " + token;
	}
	
}
