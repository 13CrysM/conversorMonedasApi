import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*S
        while (true) {
            System.out.println("\nEscribe el código de la divisa ORIGEN (ejemplo: USD, EUR, MXN) o escribe 'Q' para salir del sistema:");
            String origen = lectura.nextLine().trim().toUpperCase();
            if (origen.equals("Q")) {
                System.out.println("¡Gracias por utilizar el conversor de divisas!");
                break;
            }

            try {
                TasasMoneda tasasMoneda = consulta.buscaMoneda(origen);
                if (tasasMoneda.base_code().equalsIgnoreCase(origen)) {
                    break;
                } else {
                    System.out.println("Código no válido");
                }
            } catch (Exception e) {
                System.out.println("Error validación de código, " + e);
            }


        System.out.println(menu);

        System.out.println("\nSelecciona una opción (1 - 12):  ");
        String opcion = lectura.nextLine().trim();
        if (opcion.equalsIgnoreCase("0")){
            System.out.println("¡Gracias por utilizar el conversor de divisas!");
            lectura.close();
            return;
        }
        int indice;
        try {
            indice = Integer.parseInt(opcion);
            if (indice < 1 || indice > 12) {
                System.out.println("Opción no válida.");
                continue;
            }
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida.");
            continue;
        }

        // Solicitar cantidad a convertir
        System.out.println("Ingresa la cantidad a convertir:");
        String cantidadTexto = lectura.nextLine().trim();
        double cantidad;
        try {
            cantidad = Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            System.out.println("Cantidad no válida.");
            continue;
        }

        // Ejecutar conversión
        String destino = divisasObjetivo[indice - 1];
        try {
            Moneda moneda = consulta.buscaParMonedas(origen, destino);
            ConversorDivisa conversor = new ConversorDivisa(moneda);
            double resultado = conversor.convertir(cantidad, destino);
            System.out.printf("La cantidad de: %.2f %s equivalen a: %.2f %s%n",
                    cantidad, moneda.base_code(), resultado, destino);
        } catch (Exception e) {
            System.out.println("Error con la tasa de cambio: " + e.getMessage());
        }

    }*/
        Scanner lectura = new Scanner(System.in);
        ConsutaMoneda consulta = new ConsutaMoneda();
        String[] divisasObjetivo = {"USD", "EUR", "GBP", "CHF", "JPY", "HKD", "CAD", "CNY", "AUD", "BRL", "RUB", "MXN"};

        String menu = ("""
                1.- Convertir a Dólares Americanos (USD)
                2.- Convertir a Euros (EUR)
                3.- Convertir a Libras Esterlinas (GBP)
                4.- Convertir a Francos Suizos (CHF)
                5.- Convertir a Yenes Japoneses (JPY)
                6.- Convertir a Dólares Hongkoneses (HKD)
                7.- Convertir a Dólares Canadienses (CAD)
                8.- Convertir a Yuanes Chinos (CNY)
                9.- Convertir a Dólares Australianos (AUD)
                10.- Convertir a Reales Brasileños (BRL)
                11.- Convertir a Rublos Rusos (RUB)
                12.- Convertir a Pesos Mexicanos (MXN)
                0.- Salir
                """);

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*- Bienvenido al sistema de conversión de divisas -*");

        while (true) {
            // Solicitar y validar código de divisa origen
            String origen;
            while (true) {
                System.out.println("\nIngresa el código de la divisa ORIGEN (ejemplo: USD, EUR, MXN) o escribe '0' para salir del sistema:");
                origen = lectura.nextLine().trim().toUpperCase();

                if (origen.equals("0")) {
                    System.out.println("¡Gracias por utilizar el conversor de divisas!");
                    lectura.close();
                    return;
                }
                // Validación de la clave de la moneda
                try {
                    TasasMoneda tasasMoneda = consulta.buscaMoneda(origen);
                    //System.out.println(tasasMoneda.base_code().equalsIgnoreCase(origen));
                    if (tasasMoneda.base_code().equalsIgnoreCase(origen)) {
                        break; // Moneda válida
                    } else {
                        System.out.println("Código de moneda no válido.");
                    }
                } catch (Exception e) {
                    System.out.println("Error al validar el código de moneda: " + e.getMessage());
                }
            }

            // Menú de selección de moneda destino
            System.out.println(menu);
            System.out.println("Selecciona una opción válida (1-12):");
            String opcion = lectura.nextLine().trim();

            if (opcion.equals("0")) {
                System.out.println("¡Gracias por utilizar el conversor de divisas!");
                lectura.close();
                return;
            }

            int indice;
            try {
                indice = Integer.parseInt(opcion);
                if (indice < 1 || indice > 12) {
                    System.out.println("Debes ingresar número entre 1 y 12.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            // Solicitar cantidad a convertir
            System.out.println("Ingresa la cantidad a convertir:");
            String cantidadTexto = lectura.nextLine().trim();
            double cantidad;
            try {
                cantidad = Double.parseDouble(cantidadTexto);
            } catch (NumberFormatException e) {
                System.out.println("Cantidad no válida.");
                continue;
            }

            // Ejecutar conversión
            String destino = divisasObjetivo[indice - 1];
            try {
                Moneda moneda = consulta.buscaParMonedas(origen, destino);
                ConversorDivisa conversor = new ConversorDivisa(moneda);
                double resultado = conversor.convertir(cantidad, destino);
                System.out.printf("La cantidad de: %.2f %s equivalen a: %.2f %s%n",
                        cantidad, moneda.base_code(), resultado, destino);
            } catch (Exception e) {
                System.out.println("Error con la tasa de cambio: " + e.getMessage());
            }
        }
    }
}