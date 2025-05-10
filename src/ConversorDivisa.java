import java.util.Map;

public class ConversorDivisa {
    //private final Map<String, Double> tasas;
    private final String base;
    private final String destino;
    private final double tasa;

    public ConversorDivisa(Moneda moneda) {
        this.destino = moneda.target_code();
        this.base = moneda.base_code();
        this.tasa = moneda.conversion_rate();

        System.out.println("tasa de Conversor " + tasa);
        System.out.println("target de Conversor " + destino);
        System.out.println("base de Conversor " + base);

    }

    public double convertir(double cantidad, String destino){
        //Double tasa = tasas.get(divisasDestino);
        if (tasa > 0) {
            return cantidad * tasa;
        } else {
            throw new IllegalArgumentException("No se encontro tasa de destino: " + destino);
        }
    }

    /*public void convertir (double cantidad, String[] divisasDestino){
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
    }*/
}
