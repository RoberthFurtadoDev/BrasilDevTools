package com.example.autotools.application;

import com.example.autotools.web.dto.CnpjDataDto;
import com.example.autotools.web.dto.GeneratedCnpjDto;

import java.util.concurrent.CompletableFuture;

public interface CnpjService {
    CompletableFuture<CnpjDataDto> getCnpjData(String cnpj);
    GeneratedCnpjDto generateRandomCnpj();
}