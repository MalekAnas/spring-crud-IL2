package com.sigma_sw.crud_uppgiften.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class UIDGenerator {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 256;


    public String generateUID(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(stringBuilder);

    }
}
