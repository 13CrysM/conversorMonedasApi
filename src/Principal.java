import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ConsutaMoneda consulta = new ConsutaMoneda();
        String[] divisasObjetivo = {"USD", "EUR", "GBP", "CHF", "JPY", "HKD", "CAD", "CNY", "AUD", "BRL", "RUB", "MXN"};
        while (true) {
            System.out.println("Ingresa la moneda base:  ");
            String base = lectura.nextLine().trim().toUpperCase();
            if (base.equalsIgnoreCase("salir")){
                System.out.println("¡Gracias por utilizar el conversor de divisas!");
                break;
            }
            System.out.println("Ingresa la cantidad a convertir:" );
            String cantidadTexto = lectura.nextLine().trim();
            double cantidad;

            try {
                cantidad = Double.parseDouble(cantidadTexto);
            }catch (NumberFormatException e){
                System.out.println("Cantidad no válida.");
                continue;
            }

            try {
                Moneda moneda = consulta.buscaMoneda(base);
                System.out.println(moneda);
                ConversorDivisa conversor = new ConversorDivisa(moneda);
                conversor.convertir(cantidad, divisasObjetivo);
            } catch (Exception e){
                System.out.println("Error con la tasa de cambio." + e.getMessage());
            }
            System.out.println();
        }
        lectura.close();

    }
}
