package com.example.autotools.infrastructure.client;

import com.example.autotools.web.dto.CnpjDataDto;
import java.util.concurrent.CompletableFuture;

public interface CnpjApiClient {
    CompletableFuture<CnpjDataDto> fetchCnpjData(String cnpj);
}