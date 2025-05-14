import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private static final List<String> historial = new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void agregarConversion(String origen, String destino, double cantidad, double resultado, double tasa) {
        String registro = String.format("[%s] %.2f %s = %.2f %s (Tasa: %.6f)",
                LocalDateTime.now().format(formatter),
                cantidad, origen,
                resultado, destino,
                tasa);
        historial.add(registro);
    }

    public static List<String> obtenerHistorial() {
        return new ArrayList<>(historial);
    }

    public static void limpiarHistorial() {
        historial.clear();
    }
}
