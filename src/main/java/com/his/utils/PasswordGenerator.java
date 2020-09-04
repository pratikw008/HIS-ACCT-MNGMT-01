package com.his.utils;

import java.security.SecureRandom;

public class PasswordGenerator {
	
	public static String generateRandomPassword(int length) {
		
		if(length <= 0) throw new IllegalArgumentException("Length Must be Greater than 0");
		
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}
		return sb.toString();
	}
}