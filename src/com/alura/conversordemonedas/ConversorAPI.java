package com.alura.conversordemonedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorAPI {

    private static final String API_KEY = System.getenv("API_KEY");

    public static double obtenerTasaDeCambio(String monedaBase, String monedaDestino) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaBase;

        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear el cuerpo de la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            // Extraer la tasa de cambio del JSON
            return jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;  // Devuelve -1 en caso de error
        }
    }
}
