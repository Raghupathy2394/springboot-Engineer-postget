package com.example.Engineer.common;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.Engineer.entity.Engineer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {

	public static String secret="This is secret";
	public static long expiryduration=60 * 60;
	
	public String generateJwt(Engineer engineer) {
		
		long millyTime=System.currentTimeMillis();
		long expiryTime=millyTime+expiryduration * 1000;
		
		Date issuedAt=new Date(millyTime);
		Date ExpiryAt=new Date(expiryTime);
		Claims claims=Jwts.claims().setIssuer(engineer.getId().toString())
				.setIssuedAt(issuedAt);
		claims.setIssuedAt(issuedAt).setExpiration(ExpiryAt);
		claims.put("name", engineer.getName());
		claims.put("role", engineer.getRole());
		claims.put("city", engineer.getCity());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
public Claims verify(String authorization) throws Exception {
	try {
		Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
		System.out.println(claims.get("role"));
		return claims;
	}catch(Exception e) {
		throw new AccessDeniedException("Access Denied");
	}
}
}

