package edu.mum.onlinetest.serviceImpl;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

import edu.mum.onlinetest.service.CoachServiceInterface;

@Service
public class CoachServiceImpl implements CoachServiceInterface {

	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;
	private String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+0123456789+@";

	@Override
	public String generateId() {
		String pw = "";
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw += letters.substring(index, index + 1);
		}
		return pw;
	}

}
