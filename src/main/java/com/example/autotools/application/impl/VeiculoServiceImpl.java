package com.example.autotools.application.impl;

import com.example.autotools.application.VeiculoService;
import com.example.autotools.infrastructure.client.VeiculoApiClient;
import com.example.autotools.web.dto.VeiculoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoServiceImpl.class);
    private final VeiculoApiClient veiculoApiClient;

    public VeiculoServiceImpl(VeiculoApiClient veiculoApiClient) {
        this.veiculoApiClient = veiculoApiClient;
    }

    @Override
    public CompletableFuture<VeiculoDto> getVeiculoData(String placa) {
        // Adicionar validação de formato da placa aqui se necessário
        logger.info("Fetching data for plate: {}", placa);
        return veiculoApiClient.fetchVeiculoData(placa);
    }
}