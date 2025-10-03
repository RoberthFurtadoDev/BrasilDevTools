package com.example.autotools.web.controller;

import com.example.autotools.application.PasswordService;
import com.example.autotools.web.dto.GeneratedPasswordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
@Tag(name = "Password Tools", description = "API para geração de senhas seguras")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/generate")
    @Operation(summary = "Gera uma senha aleatória segura", description = "Cria uma senha com base nos parâmetros de complexidade fornecidos.")
    public ResponseEntity<GeneratedPasswordDto> generatePassword(
            @Parameter(description = "Comprimento da senha. Mínimo 4, máximo 128.")
            @RequestParam(defaultValue = "12") int length,
            @Parameter(description = "Incluir letras maiúsculas e minúsculas.")
            @RequestParam(defaultValue = "true") boolean letters,
            @Parameter(description = "Incluir números.")
            @RequestParam(defaultValue = "true") boolean numbers,
            @Parameter(description = "Incluir símbolos.")
            @RequestParam(defaultValue = "false") boolean symbols
    ) {
        return ResponseEntity.ok(passwordService.generatePassword(length, letters, numbers, symbols));
    }
}