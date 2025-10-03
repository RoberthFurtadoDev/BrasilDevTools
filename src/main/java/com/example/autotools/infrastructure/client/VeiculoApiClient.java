package com.example.autotools.infrastructure.client;

import com.example.autotools.web.dto.VeiculoDto;
import java.util.concurrent.CompletableFuture;

public interface VeiculoApiClient {
    CompletableFuture<VeiculoDto> fetchVeiculoData(String placa);
}