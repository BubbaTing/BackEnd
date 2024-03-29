package project2.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import project2.entities.Users;

@Service
public class JWTService {
	byte[] secretBytes;
	
	public JWTService() {
		super();
		secretBytes = getSecretBytes();
	}
	
	/**
	 * Returns a byte[] of the JWT_SECRET Environment Variable. Be sure to share this with each developer who is building the project.
	 * @return
	 */
	private byte[] getSecretBytes() {
		try {
			Path path = Paths.get(System.getenv("JWT_SECRET"));
			return Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("JWT Secret Read Error!");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns a SecretKey object, called by JWT creation/read methods
	 * @return
	 */
	private SecretKey getSecret() {
		return Keys.hmacShaKeyFor(secretBytes);
	}

	/**
	 * Returns a JWT with Issuer: "TeamVoldemort", Subject: userin"Lastname,Firstname",
	 * IssuedAt: current time, Expiration: current time + 1hr, and userid: userin.userid
	 * The created JWT will be signed with an Environment Variable named ${JWT_KEY}.
	 * @param user
	 * @return
	 */
	public String signJWT(Users user) {
		String jws = Jwts.builder()
						.setIssuer("TeamVoldemort")
						.setSubject(user.getLastname() + "," +user.getFirstname())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
						.claim("userId", user.getUser_id())
						.signWith(getSecret())
						.compact();
		return jws;
	}
	

	/**
	 * Attempts to read the UserId from a JWT String and compares it against the given userid
	 * @param jwt
	 * @return
	 */
	public boolean validateJWT(String jwsString, int useridin) {
		try {
			Jws<Claims> jwsclaims = Jwts.parser()        
					.setSigningKey(getSecret())         
					.parseClaimsJws(jwsString);
			int userid = jwsclaims.getBody().get("userId", Integer.class);
			System.out.println("Attempting JWT auth with UserId: " + useridin + " and JWT UserId: " + userid);
			if(useridin == userid) return true;
			return false;
		} catch (JwtException ex) {     // (4)
			System.out.println("JWT Authentication failure...");
			return false;
		}
	}
	
	/**
	 * Attempts to parse claims from a JWS, returns true if it is a valid JWT.
	 * DOES NOT CHECK AGAINST USER IDENTITY.
	 * @param jwsString
	 * @return
	 */
	public boolean validateJWT(String jwsString) {
		try {
			Jws<Claims> jwsclaims = Jwts.parser()        
					.setSigningKey(getSecret())         
					.parseClaimsJws(jwsString);
			return true;
		} catch (JwtException ex) {     // (4)
			System.out.println("JWT Authentication failure...");
			return false;
		}
	}
}

