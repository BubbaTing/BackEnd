package project2.services;

import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	/**
	 * generates a salt value as a byte[], length 512
	 */
	public byte[] genSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[512];
		random.nextBytes(salt);
		return salt;
	}
	
	/**
	 * returns a hash value as a byte[] given a salt value length 512 and password string
	 */
	public byte[] genHash(byte[] salt, String password){
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 512);
		SecretKeyFactory factory;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			return hash;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
