package project2.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import project2.models.Users;

@Service
public class JWTService {
	
	private String secret = System.getenv("JWT_SECRET");
	byte[] keyBytes = secret.getBytes();
	SecretKey key = Keys.hmacShaKeyFor(keyBytes);
	
	public JWTService() {
		super();
	}

	/**
	 * Returns a JWT with Issuer: "TeamVoldemort", Subject: userin"Lastname,Firstname",
	 * IssuedAt: current time, Expiration: current time + 1hr, and userid: userin.userid
	 * The created JWT will be signed with an Environment Variable named ${JWT_KEY}.
	 * @param user
	 * @return
	 */
	public String createJWT(Users user) {
		String jws = Jwts.builder()
						.setIssuer("TeamVoldemort")
						.setSubject(user.getLastname() + "," +user.getFirstname())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() - 3600 * 1000))
						.claim("userId", user.getid())
						.signWith(key)
						.compact();
		
		return jws;
	}
	

	/**
	 * Attempts to read the UserId from a JWT String, returns a 0 if the JWT is invalid.
	 * @param jwt
	 * @return
	 */
	public int readJWTUserId(String jwtString) {
		try {
			Jws<Claims> Claims = Jwts.parser()
				.requireIssuer("TeamVoldemort")
				.setSigningKey(key)
				.parseClaimsJws(jwtString);
			return Claims.getBody().get("userId", int.class);
		} catch (InvalidClaimException e){
			return 0;
		}
	}
}
