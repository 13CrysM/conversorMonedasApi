import java.util.Map;

public class ConversorDivisa {
    private final Map<String, Double> tasas;
    private final String base;

    public ConversorDivisa(Moneda moneda) {
        this.tasas = moneda.conversion_rates();
        this.base = moneda.base_code();

        System.out.println("tasas de Conversor" +tasas);
        System.out.println("base de Conversor" + base);
    }

    public void convertir (double cantidad, String[] divisasDestino){
        System.out.printf("Cantidad a convertir: %.2f %s%n", cantidad, base);
        for (String destino : divisasDestino){
            System.out.println("Destino: " + destino);
            Double tasa = tasas.get(destino);
            System.out.println("Tasa (for):" + tasa);
            if (tasa != null) {
                double resultado = cantidad * tasa;
                //System.out.printf("%.2f %s = %.4f %s%n", cantidad, base, resultado);
                System.out.printf("%.2f %s = %.4f %s%n", cantidad, base, resultado, destino);
            } else {
                System.out.println("No se encontro tasa para: " + destino);
            }
        }
    }
}
