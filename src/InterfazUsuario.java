import java.util.Scanner;

public class InterfazUsuario {
    private static final Scanner scanner = new Scanner(System.in);

    // Constructor privado para patrón Singleton
    private InterfazUsuario() {}

    // Instancia única
    private static final InterfazUsuario INSTANCIA = new InterfazUsuario();

    public static InterfazUsuario getInstance() {
        return INSTANCIA;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public double obtenerCantidadPositiva(String mensaje) {
        while (true) {
            try {
                double cantidad = Double.parseDouble(obtenerTexto(mensaje));
                if (cantidad > 0) {
                    return cantidad;
                }
                mostrarMensaje("La cantidad debe ser positiva. Intente nuevamente.");
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada inválida. Debe ingresar un número.");
            }
        }
    }

    public int obtenerOpcionMenu(String[] opciones) {
        while (true) {
            mostrarMensaje("\nMenú de opciones:");
            for (int i = 0; i < opciones.length; i++) {
                mostrarMensaje((i + 1) + ". " + opciones[i]);
            }
            mostrarMensaje("0. Salir");

            try {
                int opcion = Integer.parseInt(obtenerTexto("Seleccione una opción: "));
                if (opcion >= 0 && opcion <= opciones.length) {
                    return opcion;
                }
                mostrarMensaje("Opción fuera de rango. Intente nuevamente.");
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada inválida. Debe ingresar un número.");
            }
        }
    }

    public void mostrarResultadoConversion(double cantidad, String origen, double resultado, String destino) {
        mostrarMensaje(String.format("\nResultado: %.2f %s = %.2f %s", cantidad, origen, resultado, destino));
    }

    public void mostrarError(String mensaje) {
        System.err.println("Error: " + mensaje);
    }
}