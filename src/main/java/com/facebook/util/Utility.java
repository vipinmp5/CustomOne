package com.facebook.util;

import java.util.Locale;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class Utility {

	private static final String EMAIL_ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

	public static String randomAlphaNumeric(int count) {
		String ALPHA_STRING = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_STRING.length());
			builder.append(ALPHA_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static String randomEmail(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * EMAIL_ALPHA_NUMERIC_STRING
					.length());
			builder.append(EMAIL_ALPHA_NUMERIC_STRING.charAt(character));
		}
		String userName = builder.toString();
		return userName + "@" + PropertyManager.getInstance().getEmailDomain();
	}

	public static String randomEmailFaker() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale(
				"en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@"
				+ PropertyManager.getInstance().getEmailDomain());
		return email;
	}

}
