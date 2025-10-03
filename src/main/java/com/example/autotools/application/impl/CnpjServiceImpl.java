package com.example.autotools.application.impl;

import com.example.autotools.application.CnpjService;
import com.example.autotools.domain.validation.CnpjValidator;
import com.example.autotools.infrastructure.client.CnpjApiClient;
import com.example.autotools.web.dto.CnpjDataDto;
import com.example.autotools.web.dto.GeneratedCnpjDto;
import com.example.autotools.web.exception.InvalidCnpjException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;

@Service
public class CnpjServiceImpl implements CnpjService {

    private static final Logger logger = LoggerFactory.getLogger(CnpjServiceImpl.class);
    private final CnpjApiClient cnpjApiClient;
    private final SecureRandom random = new SecureRandom();


    public CnpjServiceImpl(CnpjApiClient cnpjApiClient) {
        this.cnpjApiClient = cnpjApiClient;
    }

    @Override
    public CompletableFuture<CnpjDataDto> getCnpjData(String cnpj) {
        if (!CnpjValidator.isValid(cnpj)) {
            logger.warn("Invalid CNPJ format received: {}", cnpj);
            throw new InvalidCnpjException("CNPJ inválido: " + cnpj);
        }
        logger.info("Fetching data for CNPJ: {}", cnpj);
        return cnpjApiClient.fetchCnpjData(cnpj.replaceAll("[^0-9]", ""));
    }

    @Override
    public GeneratedCnpjDto generateRandomCnpj() {
        int[] base = new int[8];
        for (int i = 0; i < 8; i++) {
            base[i] = random.nextInt(10);
        }

        String baseCnpj = String.format("%d%d%d%d%d%d%d%d0001",
                base[0], base[1], base[2], base[3],
                base[4], base[5], base[6], base[7]);

        int dv1 = CnpjValidator.calculateDigit(baseCnpj, new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});
        int dv2 = CnpjValidator.calculateDigit(baseCnpj + dv1, new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});

        String unformatted = baseCnpj + dv1 + dv2;
        String formatted = String.format("%s.%s.%s/%s-%s",
                unformatted.substring(0, 2),
                unformatted.substring(2, 5),
                unformatted.substring(5, 8),
                unformatted.substring(8, 12),
                unformatted.substring(12, 14));

        logger.debug("Generated random CNPJ: {}", formatted);
        return new GeneratedCnpjDto(formatted, unformatted);
    }
}