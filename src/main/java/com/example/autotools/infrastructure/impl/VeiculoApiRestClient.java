package com.example.autotools.infrastructure.impl;

import com.example.autotools.infrastructure.client.VeiculoApiClient;
import com.example.autotools.web.dto.VeiculoDto;
import com.example.autotools.web.exception.ApiCommunicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Component
@ConditionalOnExpression("'${api.veiculo.url:}' != ''")
public class VeiculoApiRestClient implements VeiculoApiClient {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoApiRestClient.class);
    private final WebClient webClient;
    private final String apiUrl;

    public VeiculoApiRestClient(WebClient webClient, @Value("${api.veiculo.url}") String apiUrl) {
        this.webClient = webClient;
        this.apiUrl = apiUrl;
    }

    @Override
    public CompletableFuture<VeiculoDto> fetchVeiculoData(String placa) {
        String url = String.format("%s/%s", apiUrl, placa);
        logger.debug("Calling REAL Veiculo API at: {}", url);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(VeiculoDto.class)
                .onErrorMap(e -> new ApiCommunicationException("Failed to fetch Veiculo data from external API.", e))
                .toFuture();
    }
}