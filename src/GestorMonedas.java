public class GestorMonedas {
    public static final String[] divisasObjetivo = {
            "USD", "EUR", "GBP", "CHF", "JPY", "HKD",
            "CAD", "CNY", "AUD", "BRL", "RUB", "MXN",
            "ARS", "VEF", "BOB", "CLP", "COP", "UYU"
    };
    public static String[] obtenerNombresDivisas() {
        String[] nombres = new String[divisasObjetivo.length];
        for (int i = 0; i < divisasObjetivo.length; i++) {
            nombres[i] = obtenerNombreDivisa(divisasObjetivo[i]);
        }
        return nombres;
    }
    public static String obtenerNombreDivisa(String codigo) {
        return switch(codigo.toUpperCase()) {
            case "USD" -> "Dólar Estadounidense";
            case "EUR" -> "Euro";
            case "GBP" -> "Libra Esterlina";
            case "CHF" -> "Franco Suizo";
            case "JPY" -> "Yen Japonés";
            case "HDK" -> "Dolar de Hong Konk";
            case "CAD" -> "Dolar Canadiense";
            case "CNY" -> "Yuan Chino";
            case "AUD" -> "Dolar Asutraliano";
            case "BRL" -> "Real Brasileño";
            case "RUB" -> "Rublo Ruso";
            case "MXN" -> "Peso Mexicano";
            case "ARS" -> "Peso Argentino";
            case "VEF" -> "Bolivar Fuerte Venezolano";
            case "BOB" -> "Boliviano";
            case "CLP" -> "Peso Chileno";
            case "COP" -> "Peso Colombiano";
            case "UYU" -> "Peso Uruguayo";
            default -> codigo;
        };
    }

    public static boolean esDivisaValida(String codigo) {
        for (String divisa : divisasObjetivo) {
            if (divisa.equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}
