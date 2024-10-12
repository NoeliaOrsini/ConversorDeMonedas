package com.alura.conversordemonedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("\n****************************************");
        System.out.println("\n Bienvenido/a al Conversor de Monedas");
        System.out.println("\n****************************************");

        String menu = """
                
                ** Escribe el número de la opción deseada de moneda a convertir: **
                1 - Dólar => Pesos argentinos
                2 - Pesos argentinos => Dólar
                3 - Dólar => Real brasileño
                4 - Real brasileño => Dólar
                5 - Dólar => Peso colombiano
                6 - Peso colombiano => Dólar
                7 - Dólar => Peso chileno
                8 - Peso chileno => Dólar
                9 - Dólar => Boliviano
                10 - Boliviano => Dólar
                11 - Salir
                **********************************************************
                """;

        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println(menu);
            System.out.print("Selecciona una opción: ");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> realizarConversion(opcion, teclado);
                case 11 -> {
                    System.out.println("Saliendo del programa...");
                    System.out.println("Gracias por utilizar nuestros servicios.");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }

        teclado.close();
    }

    private static void realizarConversion(int opcion, Scanner teclado) {
        String monedaOrigen = "";
        String monedaDestino = "";

        switch (opcion) {
            case 1 -> { monedaOrigen = "USD"; monedaDestino = "ARS"; }
            case 2 -> { monedaOrigen = "ARS"; monedaDestino = "USD"; }
            case 3 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
            case 4 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
            case 5 -> { monedaOrigen = "USD"; monedaDestino = "COP"; }
            case 6 -> { monedaOrigen = "COP"; monedaDestino = "USD"; }
            case 7 -> { monedaOrigen = "USD"; monedaDestino = "CLP"; }
            case 8 -> { monedaOrigen = "CLP"; monedaDestino = "USD"; }
            case 9 -> { monedaOrigen = "USD"; monedaDestino = "BOB"; }
            case 10 -> { monedaOrigen = "BOB"; monedaDestino = "USD"; }
        }

        System.out.print("Ingresa la cantidad de " + obtenerNombreMoneda(monedaOrigen) + ": ");
        String input = teclado.next();
        input = input.replace(",", ".");  // Reemplazar comas por puntos para asegurar el formato decimal

        double cantidad;
        try {
            cantidad = Double.parseDouble(input);  // Convertir el input a double
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor ingresa un número válido.");
            return;
        }

        // Validar que no se ingresen números negativos
        if (cantidad < 0) {
            System.out.println("Cantidad inválida. No se permiten números negativos.");
            return;
        }

        double tasaCambio = ConversorAPI.obtenerTasaDeCambio(monedaOrigen, monedaDestino);

        if (tasaCambio != -1) { // Asegúrate de que la tasa no sea -1 (error)
            double resultado = cantidad * tasaCambio;
            System.out.println(String.format("%.2f %s son %.2f %s.", cantidad, obtenerNombreMoneda(monedaOrigen),
                    resultado, obtenerNombreMoneda(monedaDestino)));

            // Crear un objeto de la clase Busqueda
            Busqueda busqueda = new Busqueda(monedaOrigen, cantidad, monedaDestino, tasaCambio, resultado);

            // Guardar la búsqueda en un archivo JSON utilizando HistorialDeBusqueda
            HistorialDeBusqueda.guardarBusqueda(busqueda);
        } else {
            System.out.println("Error al obtener la tasa de cambio.");
        }
    }

    private static String obtenerNombreMoneda(String codigo) {
        return switch (codigo) {
            case "USD" -> "Dólares";
            case "ARS" -> "Pesos argentinos";
            case "BRL" -> "Reales brasileños";
            case "COP" -> "Pesos colombianos";
            case "CLP" -> "Pesos chilenos";
            case "BOB" -> "Bolivianos";
            default -> "Moneda desconocida";
        };
    }
}
