package com.example.autotools.domain;

import java.util.Objects;

public class Cnpj {
    private final String value;

    public Cnpj(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ value cannot be null or empty.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getUnformattedValue() {
        return value.replaceAll("[^0-9]", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cnpj cnpj = (Cnpj) o;
        return Objects.equals(getUnformattedValue(), cnpj.getUnformattedValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnformattedValue());
    }

    @Override
    public String toString() {
        return "Cnpj{" +
                "value='" + value + '\'' +
                '}';
    }
}