import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsutaMoneda {
    public TasasMoneda buscaMoneda(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f2c3223eb6f05839fc291c4e/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Consulta moneda origen, exitosa");
            return new Gson().fromJson(response.body(), TasasMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no enconrada.");
        }
    }

    public Moneda buscaParMonedas(String monedaBase, String monedaConvertida){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f2c3223eb6f05839fc291c4e/pair/" + monedaBase + "/"+ monedaConvertida);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Consulta exitosa");
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no enconrada.");
        }
    }
}
