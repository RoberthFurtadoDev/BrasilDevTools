package com.example.autotools.web.dto;

public class GeneratedIeDto {
    private String uf;
    private String inscricaoEstadual;

    public GeneratedIeDto(String uf, String inscricaoEstadual) {
        this.uf = uf;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    // Getters
    public String getUf() {
        return uf;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
}