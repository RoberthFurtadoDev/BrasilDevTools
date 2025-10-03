package com.example.autotools.application;

import com.example.autotools.web.dto.VeiculoDto;
import java.util.concurrent.CompletableFuture;

public interface VeiculoService {
    CompletableFuture<VeiculoDto> getVeiculoData(String placa);
}