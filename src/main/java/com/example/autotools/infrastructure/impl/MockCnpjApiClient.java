// CÓDIGO CORRIGIDO
package com.example.autotools.infrastructure.impl;

import com.example.autotools.infrastructure.client.CnpjApiClient;
import com.example.autotools.web.dto.CnpjDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@ConditionalOnExpression("'${api.receitaws.url:}' == ''")
public class MockCnpjApiClient implements CnpjApiClient {

    private static final Logger logger = LoggerFactory.getLogger(MockCnpjApiClient.class);

    @Override
    public CompletableFuture<CnpjDataDto> fetchCnpjData(String cnpj) {
        logger.warn("Using MOCK CNPJ API Client. Returning static data for CNPJ: {}", cnpj);
        CnpjDataDto mockData = new CnpjDataDto();
        mockData.setNome("EMPRESA FICTICIA LTDA (MOCK)");
        mockData.setFantasia("NOME FANTASIA (MOCK)");
        mockData.setCnpj(cnpj);
        mockData.setLogradouro("RUA DOS BOBOS, 0");
        mockData.setMunicipio("SAO PAULO");
        mockData.setUf("SP");
        mockData.setStatus("ATIVA");
        return CompletableFuture.completedFuture(mockData);
    }
}