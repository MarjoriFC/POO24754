package main.ejercicio1;

public class Localidad {
    private String nombre;
    private int capacidadTotal;
    private int boletosVendidos;
    private double precio;

    public Localidad(String nombre, int capacidadTotal, double precio) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.precio = precio;
        this.boletosVendidos = 0;
    }

    public boolean hayEspacio(int cantidad) {
        return (capacidadTotal - boletosVendidos) >= cantidad;
    }

    public boolean validarPresupuesto(double presupuesto) {
        return presupuesto >= precio;
    }

    public int venderBoletos(int cantidad) {
        int boletosDisponibles = capacidadTotal - boletosVendidos;
        int boletosVendidosAhora = Math.min(cantidad, boletosDisponibles);
        boletosVendidos += boletosVendidosAhora;
        return boletosVendidosAhora;
    }

    public int consultarDisponibilidad() {
        return capacidadTotal - boletosVendidos;
    }

    public double obtenerIngresos() {
        return boletosVendidos * precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
//Marjori Flores (24754) All rights reserved...
