import java.io.IOException;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        InterfazUsuario ui = InterfazUsuario.getInstance();
        ConsultaMoneda consulta = new ConsultaMoneda();

        ui.mostrarMensaje("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        ui.mostrarMensaje("*- Bienvenido al sistema de conversión de divisas by Crystian Muro-*");
        ui.mostrarMensaje("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        while (true) {
            String[] opcionesPrincipales = {"Realizar conversión de divisas", "Ver historial de conversiones", "Eliminar historial"};
            int opcion = ui.obtenerOpcionMenu(opcionesPrincipales);

            switch (opcion) {
                case 1:
                    realizarConversion(ui, consulta);
                    break;
                case 2:
                    mostrarHistorial(ui);
                    break;
                case 3:
                    HistorialConversiones.limpiarHistorial();
                    break;
                case 0:
                    ui.mostrarMensaje("¡Gracias por utilizar el conversor de divisas!");
                    return;
                default:
                    ui.mostrarError("Opción no válida");
            }
        }
    }

    private static void realizarConversion(InterfazUsuario ui, ConsultaMoneda consulta) {
        try {
            // Obtener divisa origen
            String origen = ui.obtenerTexto("\nIngrese el código de la divisa ORIGEN (ej: USD, EUR, MXN): ").toUpperCase();
            if (!GestorMonedas.esDivisaValida(origen)) {
                ui.mostrarError("Divisa no soportada");
                return;
            }

            // Obtener divisa destino
            ui.mostrarMensaje("\nSeleccione la divisa DESTINO:");
            int indiceDestino = ui.obtenerOpcionMenu(GestorMonedas.obtenerNombresDivisas());
            if (indiceDestino == 0) return;
            String destino = GestorMonedas.divisasObjetivo[indiceDestino - 1];

            // Obtener cantidad
            double cantidad = ui.obtenerCantidadPositiva("\nIngrese la cantidad a convertir: ");

            // Realizar conversión
            Moneda moneda = consulta.buscarParMonedas(origen, destino);
            ConversorDivisa conversor = new ConversorDivisa(moneda);
            double resultado = conversor.convertir(cantidad, destino);

            // Mostrar resultado y guardar en historial
            ui.mostrarResultadoConversion(cantidad, origen, resultado, destino);
            HistorialConversiones.agregarConversion(origen, destino, cantidad, resultado, moneda.conversion_rate());

        } catch (Exception e) {
            ui.mostrarError(e.getMessage());
        }
    }

    private static void mostrarHistorial(InterfazUsuario ui) {
        List<String> historial = HistorialConversiones.obtenerHistorial();
        if (historial.isEmpty()) {
            ui.mostrarMensaje("\nNo hay conversiones en el historial.");
            return;
        }

        ui.mostrarMensaje("\nHistorial de conversiones:");
        ui.mostrarMensaje("----------------------------------------");
        historial.forEach(ui::mostrarMensaje);
        ui.mostrarMensaje("----------------------------------------");
    }
}