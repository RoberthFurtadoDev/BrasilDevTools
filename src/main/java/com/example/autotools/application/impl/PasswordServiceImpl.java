package com.example.autotools.application.impl;

import com.example.autotools.application.PasswordService;
import com.example.autotools.web.dto.GeneratedPasswordDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    private static final Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private final SecureRandom random = new SecureRandom();

    @Override
    public GeneratedPasswordDto generatePassword(int length, boolean useLetters, boolean useNumbers, boolean useSymbols) {
        if (length < 4 || length > 128) {
            throw new IllegalArgumentException("Password length must be between 4 and 128 characters.");
        }
        if (!useLetters && !useNumbers && !useSymbols) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        StringBuilder charPool = new StringBuilder();
        List<Character> passwordChars = new ArrayList<>();

        if (useLetters) {
            charPool.append(LETTERS);
            passwordChars.add(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        if (useNumbers) {
            charPool.append(NUMBERS);
            passwordChars.add(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        if (useSymbols) {
            charPool.append(SYMBOLS);
            passwordChars.add(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
        }

        for (int i = passwordChars.size(); i < length; i++) {
            passwordChars.add(charPool.charAt(random.nextInt(charPool.length())));
        }

        Collections.shuffle(passwordChars, random);
        StringBuilder password = new StringBuilder();
        passwordChars.forEach(password::append);

        logger.debug("Generated a password with length {}", length);
        return new GeneratedPasswordDto(password.toString());
    }
}