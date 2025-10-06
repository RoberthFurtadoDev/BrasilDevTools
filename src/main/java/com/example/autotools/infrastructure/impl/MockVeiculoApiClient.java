package com.example.autotools.infrastructure.impl;

import com.example.autotools.infrastructure.client.VeiculoApiClient;
import com.example.autotools.web.dto.VeiculoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@ConditionalOnExpression("'${api.veiculo.url:}' == ''")
public class MockVeiculoApiClient implements VeiculoApiClient {

    private static final Logger logger = LoggerFactory.getLogger(MockVeiculoApiClient.class);

    @Override
    public CompletableFuture<VeiculoDto> fetchVeiculoData(String placa) {
        logger.warn("Using MOCK Veiculo API Client because 'api.veiculo.url' is not set. Returning static data for placa: {}", placa);
        VeiculoDto mockData = new VeiculoDto();
        mockData.setPlaca(placa);
        mockData.setMarca("MARCA FICTÍCIA");
        mockData.setModelo("MODELO MOCK");
        mockData.setCor("PRETO");
        mockData.setAno("2025");
        mockData.setCidade("CIDADE EXEMPLO");
        mockData.setUf("EX");
        mockData.setSituacao("REGULAR (MOCK)");
        return CompletableFuture.completedFuture(mockData);
    }
}