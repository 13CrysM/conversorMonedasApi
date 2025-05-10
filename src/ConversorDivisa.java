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

        /*System.out.println("tasa de Conversor " + tasa);
        System.out.println("target de Conversor " + destino);
        System.out.println("base de Conversor " + base);*/

    }

    public double convertir(double cantidad, String destino){
        //Double tasa = tasas.get(divisasDestino);
        if (tasa > 0) {
            return cantidad * tasa;
        } else {
            throw new IllegalArgumentException("No se encontro tasa de destino: " + destino);
        }
    }
}
