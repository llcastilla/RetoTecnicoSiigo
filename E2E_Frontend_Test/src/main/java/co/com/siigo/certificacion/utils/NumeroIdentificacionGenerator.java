package co.com.siigo.certificacion.utils;

import java.util.Random;

public class NumeroIdentificacionGenerator {

    public static String generar() {
        Random random = new Random();

        // prefijo fijo
        String base = "1063965";

        // generar 3 dígitos aleatorios
        int randomDigits = 11 + random.nextInt(99); // garantiza siempre 3 dígitos (100-999)

        return base + randomDigits;
    }

    public static void validar(String numId) {
        if (numId == null || numId.isEmpty()) {
            throw new IllegalArgumentException("El número de identificación no puede ser nulo o vacío");
        }
        if (!numId.startsWith("10639658")) {
            throw new IllegalArgumentException("El número de identificación debe comenzar con 10639658");
        }
        if (numId.length() != 10) {
            throw new IllegalArgumentException("El número de identificación debe tener exactamente 10 dígitos");
        }
        if (!numId.matches("\\d+")) {
            throw new IllegalArgumentException("El número de identificación solo puede contener dígitos");
        }
    }
}
