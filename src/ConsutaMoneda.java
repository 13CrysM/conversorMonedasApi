import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsutaMoneda {
    public Moneda buscaMoneda(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f2c3223eb6f05839fc291c4e/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no enconrada.");
        }

        /*String json = response.body();
        System.out.println(json);*/
    }
}
