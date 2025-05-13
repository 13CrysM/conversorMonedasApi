import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "f2c3223eb6f05839fc291c4e";

    public TasasMoneda buscarMoneda(String moneda){
        URI direccion = URI.create(API_URL + API_KEY + "/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("Consulta moneda origen, exitosa");
            if(response.statusCode() != 200){
                throw new RuntimeException("Error en el API: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), TasasMoneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con el servisio de divisas: " + e.getMessage());
        }
    }

    public Moneda buscarParMonedas(String monedaBase, String monedaConvertida){
        URI direccion = URI.create(API_URL + API_KEY + "/pair/" + monedaBase + "/"+ monedaConvertida);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("Consulta exitosa");
            if(response.statusCode() != 200){
                throw new RuntimeException("Error en el API: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con el servisio de divisas: " + e.getMessage());
        }
    }
}
