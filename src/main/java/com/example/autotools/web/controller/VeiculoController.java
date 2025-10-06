package com.example.autotools.web.controller;

import com.example.autotools.application.VeiculoService;
import com.example.autotools.web.dto.VeiculoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/veiculo")
@Tag(name = "Veículo Tools", description = "API para consulta de dados de veículos por placa")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{placa}")
    @Operation(summary = "Consulta dados de um veículo pela placa", description = "Retorna informações de um veículo a partir de uma API externa ou de um mock.")
    public CompletableFuture<ResponseEntity<VeiculoDto>> getVeiculoData(@PathVariable String placa) {
        return veiculoService.getVeiculoData(placa)
                .thenApply(ResponseEntity::ok);
    }
}