package com.example.autotools.application;

import com.example.autotools.web.dto.GeneratedPasswordDto;

public interface PasswordService {
    GeneratedPasswordDto generatePassword(int length, boolean useLetters, boolean useNumbers, boolean useSymbols);
}