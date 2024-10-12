package com.alura.conversordemonedas;

import com.google.gson.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeBusqueda {
    private static final String RUTA_ARCHIVO = "historial.json";
    private static List<Busqueda> historial = new ArrayList<>();

    public static void guardarBusqueda(Busqueda busqueda) {
        historial.add(busqueda); // Agregar búsqueda a la lista
        escribirHistorialEnArchivo(); // Escribir en el archivo JSON
    }

    private static void escribirHistorialEnArchivo() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Formateadores para las tasas y resultados
        DecimalFormat decimalFormatTasa = new DecimalFormat("#.##########"); // Sin ceros a la derecha
        DecimalFormat decimalFormatResultado = new DecimalFormat("#.##"); // Dos decimales

        JsonArray jsonArray = new JsonArray();

        // Agregar todas las búsquedas al JSON
        for (Busqueda busqueda : historial) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("monedaOrigen", busqueda.getMonedaOrigen());
            jsonObject.addProperty("cantidad", busqueda.getCantidad());
            jsonObject.addProperty("monedaDestino", busqueda.getMonedaDestino());
            jsonObject.addProperty("tasa", decimalFormatTasa.format(busqueda.getTasa())); // Formatear tasa
            jsonObject.addProperty("resultado", decimalFormatResultado.format(busqueda.getResultado())); // Formatear resultado
            jsonArray.add(jsonObject);
        }

        // Guardar el JSON en un archivo
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            writer.write(gson.toJson(jsonArray));
            writer.close();
            System.out.println("Historial de búsquedas guardado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}
