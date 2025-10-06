package com.example.autotools.application;

import com.example.autotools.application.impl.PasswordServiceImpl;
import com.example.autotools.web.dto.GeneratedPasswordDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceImplTest {

    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordServiceImpl();
    }

    @Test
    void shouldGeneratePasswordWithCorrectLength() {
        GeneratedPasswordDto result = passwordService.generatePassword(16, true, true, true);
        assertEquals(16, result.getPassword().length());
    }

    @Test
    void shouldContainLettersNumbersAndSymbols() {
        String password = passwordService.generatePassword(20, true, true, true).getPassword();
        assertTrue(password.matches(".*[a-zA-Z]+.*"));
        assertTrue(password.matches(".*[0-9]+.*"));
        assertTrue(password.matches(".*[!@#$%^&*()_+-=\\[\\]{}|;:,.<>?]+.*"));
    }

    @Test
    void shouldThrowExceptionForInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> passwordService.generatePassword(3, true, true, true));
        assertThrows(IllegalArgumentException.class, () -> passwordService.generatePassword(200, true, true, true));
    }

    @Test
    void shouldThrowExceptionWhenNoCharacterTypeIsSelected() {
        assertThrows(IllegalArgumentException.class, () -> passwordService.generatePassword(12, false, false, false));
    }
}