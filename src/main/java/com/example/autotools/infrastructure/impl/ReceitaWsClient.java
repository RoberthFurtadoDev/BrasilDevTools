// CÓDIGO CORRIGIDO
package com.example.autotools.infrastructure.impl;

import com.example.autotools.infrastructure.client.CnpjApiClient;
import com.example.autotools.web.dto.CnpjDataDto;
import com.example.autotools.web.exception.ApiCommunicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Component
@ConditionalOnExpression("'${api.receitaws.url:}' != ''")
public class ReceitaWsClient implements CnpjApiClient {

    private static final Logger logger = LoggerFactory.getLogger(ReceitaWsClient.class);
    private final WebClient webClient;
    private final String apiUrl;

    public ReceitaWsClient(WebClient webClient, @Value("${api.receitaws.url}") String apiUrl) {
        this.webClient = webClient;
        this.apiUrl = apiUrl;
    }

    @Override
    public CompletableFuture<CnpjDataDto> fetchCnpjData(String cnpj) {
        String url = String.format("%s/%s", apiUrl, cnpj);
        logger.debug("Calling REAL API at: {}", url);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CnpjDataDto.class)
                .onErrorMap(e -> new ApiCommunicationException("Failed to fetch CNPJ data from external API.", e))
                .toFuture();
    }
}