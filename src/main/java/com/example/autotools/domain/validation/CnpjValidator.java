package com.example.autotools.domain.validation;

public class CnpjValidator {

    public static boolean isValid(String cnpj) {
        String cleanedCnpj = cnpj.replaceAll("[^0-9]", "");

        if (cleanedCnpj.length() != 14 || hasAllSameDigits(cleanedCnpj)) {
            return false;
        }

        try {
            String baseCnpj = cleanedCnpj.substring(0, 12);
            int dv1 = calculateDigit(baseCnpj, new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});
            int dv2 = calculateDigit(baseCnpj + dv1, new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});

            return cleanedCnpj.equals(baseCnpj + dv1 + dv2);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean hasAllSameDigits(String cnpj) {
        char first = cnpj.charAt(0);
        for (int i = 1; i < cnpj.length(); i++) {
            if (cnpj.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }

    public static int calculateDigit(String base, int[] weights) {
        int sum = 0;
        for (int i = 0; i < base.length(); i++) {
            sum += Character.getNumericValue(base.charAt(i)) * weights[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
}