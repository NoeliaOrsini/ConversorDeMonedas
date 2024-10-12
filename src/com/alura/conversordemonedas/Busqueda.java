package com.alura.conversordemonedas;

public class Busqueda {
    private final String monedaOrigen;
    private final double cantidad;
    private final String monedaDestino;
    private final double tasa;
    private final double resultado;

    public Busqueda(String monedaOrigen, double cantidad, String monedaDestino, double tasa, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.cantidad = cantidad;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
        this.resultado = resultado;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }

    public double getResultado() {
        return resultado;
    }
}
