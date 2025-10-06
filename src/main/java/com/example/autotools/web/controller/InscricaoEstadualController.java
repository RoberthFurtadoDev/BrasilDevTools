package com.example.autotools.web.controller;

import com.example.autotools.application.InscricaoEstadualService;
import com.example.autotools.domain.Uf;
import com.example.autotools.web.dto.GeneratedIeDto;
import com.example.autotools.web.exception.UnsupportedUfException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscricao-estadual")
@Tag(name = "Inscrição Estadual Tools", description = "API para geração de Inscrição Estadual")
public class InscricaoEstadualController {

    private final InscricaoEstadualService ieService;

    public InscricaoEstadualController(InscricaoEstadualService ieService) {
        this.ieService = ieService;
    }

    @GetMapping("/random")
    @Operation(summary = "Gera uma Inscrição Estadual válida", description = "Gera um número de Inscrição Estadual para uma UF suportada (SP, MG, RJ, PR).")
    public ResponseEntity<GeneratedIeDto> generateRandomIe(
            @Parameter(description = "Sigla da Unidade Federativa (UF). Ex: SP", required = true)
            @RequestParam String uf) {

        Uf ufEnum = Uf.fromString(uf.toUpperCase())
                .orElseThrow(() -> new UnsupportedUfException("UF inválida ou não suportada: " + uf));

        return ResponseEntity.ok(ieService.generateRandomIe(ufEnum));
    }
}