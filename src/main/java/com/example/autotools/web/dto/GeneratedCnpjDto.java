package com.example.autotools.web.dto;

public class GeneratedCnpjDto {
    private String formatted;
    private String unformatted;

    public GeneratedCnpjDto(String formatted, String unformatted) {
        this.formatted = formatted;
        this.unformatted = unformatted;
    }

    // Getters and Setters
    public String getFormatted() { return formatted; }
    public void setFormatted(String formatted) { this.formatted = formatted; }
    public String getUnformatted() { return unformatted; }
    public void setUnformatted(String unformatted) { this.unformatted = unformatted; }
}