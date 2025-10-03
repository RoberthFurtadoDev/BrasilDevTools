package com.example.autotools.application;

import com.example.autotools.application.impl.CnpjServiceImpl;
import com.example.autotools.domain.validation.CnpjValidator;
import com.example.autotools.infrastructure.client.CnpjApiClient;
import com.example.autotools.web.dto.GeneratedCnpjDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CnpjServiceImplTest {

    @Mock
    private CnpjApiClient cnpjApiClient;

    private CnpjService cnpjService;

    @BeforeEach
    void setUp() {
        cnpjService = new CnpjServiceImpl(cnpjApiClient);
    }

    @RepeatedTest(10)
    void shouldGenerateValidAndFormattedCnpj() {
        GeneratedCnpjDto result = cnpjService.generateRandomCnpj();

        assertNotNull(result);
        assertNotNull(result.getFormatted());
        assertNotNull(result.getUnformatted());

        assertEquals(18, result.getFormatted().length()); // XX.XXX.XXX/XXXX-XX
        assertEquals(14, result.getUnformatted().length());

        assertTrue(result.getFormatted().matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}"));
        assertTrue(CnpjValidator.isValid(result.getUnformatted()));
        assertTrue(CnpjValidator.isValid(result.getFormatted()));
    }
}