package com.example.autotools.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Uf {
    // Região Norte
    AC, // Acre
    AP, // Amapá
    AM, // Amazonas
    PA, // Pará
    RO, // Rondônia
    RR, // Roraima
    TO, // Tocantins

    // Região Nordeste
    AL, // Alagoas
    BA, // Bahia
    CE, // Ceará
    MA, // Maranhão
    PB, // Paraíba
    PE, // Pernambuco
    PI, // Piauí
    RN, // Rio Grande do Norte
    SE, // Sergipe

    // Região Centro-Oeste
    DF, // Distrito Federal
    GO, // Goiás
    MT, // Mato Grosso
    MS, // Mato Grosso do Sul

    // Região Sudeste
    ES, // Espírito Santo
    MG, // Minas Gerais
    RJ, // Rio de Janeiro
    SP, // São Paulo

    // Região Sul
    PR, // Paraná
    RS, // Rio Grande do Sul
    SC; // Santa Catarina

    public static Optional<Uf> fromString(String value) {
        return Arrays.stream(values())
                .filter(uf -> uf.name().equalsIgnoreCase(value))
                .findFirst();
    }
}