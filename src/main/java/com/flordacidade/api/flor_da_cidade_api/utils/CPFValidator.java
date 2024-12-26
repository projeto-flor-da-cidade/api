package com.flordacidade.api.flor_da_cidade_api.utils;

public class CPFValidator {

    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CPF inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstDigit = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int secondDigit = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        // Verifica os dígitos calculados com os fornecidos
        return firstDigit == Character.getNumericValue(cpf.charAt(9)) &&
                secondDigit == Character.getNumericValue(cpf.charAt(10));
    }
}
