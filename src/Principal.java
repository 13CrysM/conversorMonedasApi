import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ConsutaMoneda consulta = new ConsutaMoneda();
        System.out.println("Ingresa la moneda:  ");
        try {
            var denMon = lectura.nextLine();
            Moneda moneda = consulta.buscaMoneda(denMon);
            System.out.println(moneda);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //System.out.println("Conversión de monedas.");
        System.out.println("Adios");

        String direccion = "https://v6.exchangerate-api.com/v6/f2c3223eb6f05839fc291c4e/latest/MXN";


    }
}
