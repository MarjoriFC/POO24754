package main.ejercicio1;

/**
 *
 * @author Marjori
 */
public class Ticket {
    private String numero;
    private String localidad;
    private double precio;

    /**
     *
     * @param numero
     * @param localidad
     * @param precio
     */
    public Ticket(String numero, String localidad, double precio) {
        this.numero = numero;
        this.localidad = localidad;
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @return
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }
}
//Marjori Flores (24754) All rights reserved...

