package com.example.autotools.web.controller;

import com.example.autotools.application.CnpjService;
import com.example.autotools.web.dto.CnpjDataDto;
import com.example.autotools.web.dto.GeneratedCnpjDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/cnpj")
@Tag(name = "CNPJ Tools", description = "APIs para consulta e geração de CNPJ")
public class CnpjController {

    private final CnpjService cnpjService;

    public CnpjController(CnpjService cnpjService) {
        this.cnpjService = cnpjService;
    }

    @GetMapping("/{cnpj}")
    @Operation(summary = "Consulta dados de um CNPJ", description = "Retorna informações públicas de um CNPJ a partir de uma API externa ou de um mock.")
    public CompletableFuture<ResponseEntity<CnpjDataDto>> getCnpjData(@PathVariable String cnpj) {
        return cnpjService.getCnpjData(cnpj)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/random")
    @Operation(summary = "Gera um CNPJ válido", description = "Gera um número de CNPJ aleatório com dígitos verificadores válidos.")
    public ResponseEntity<GeneratedCnpjDto> generateRandomCnpj() {
        return ResponseEntity.ok(cnpjService.generateRandomCnpj());
    }
}