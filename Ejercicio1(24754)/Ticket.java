package main.ejercicio1;

public class Ticket {
    private String numero;
    private String localidad;
    private double precio;

    public Ticket(String numero, String localidad, double precio) {
        this.numero = numero;
        this.localidad = localidad;
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public double getPrecio() {
        return precio;
    }
}
//Marjori Flores (24754) All rights reserved...