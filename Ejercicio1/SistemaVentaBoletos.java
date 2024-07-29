package main.ejercicio1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaVentaBoletos {
    private Localidad[] localidades;
    private int siguienteCorrelativo;
    private double ingresosTotales;
    private String fechaActual;

    public SistemaVentaBoletos(Localidad[] localidades) {
        this.localidades = localidades;
        this.siguienteCorrelativo = 1;
        this.ingresosTotales = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        this.fechaActual = sdf.format(new Date());
    }

    public Ticket comprarBoleto(String nombre, String email, int cantidad, double presupuesto, int localidadSeleccionada) {
        if (localidadSeleccionada < 0 || localidadSeleccionada >= localidades.length) {
            throw new IllegalArgumentException("Localidad seleccionada no válida.");
        }

        Localidad localidad = localidades[localidadSeleccionada];

        if (!localidad.validarPresupuesto(presupuesto)) {
            System.out.println("El presupuesto no es suficiente para esta localidad.");
            return null;
        }

        if (!localidad.hayEspacio(cantidad)) {
            System.out.println("No hay suficiente espacio en la localidad. Vendiendo la mayor cantidad posible.");
            cantidad = localidad.consultarDisponibilidad();
        }

        int boletosVendidos = localidad.venderBoletos(cantidad);
        double precio = localidad.getPrecio();
        ingresosTotales += boletosVendidos * precio;

        String numeroBoleto = fechaActual + String.format("%03d", siguienteCorrelativo++);
        Ticket ticket = new Ticket(numeroBoleto, localidad.getNombre(), precio);
        System.out.println("Boleto comprado exitosamente: " + ticket.getNumero());

        return ticket;
    }

    public int consultarDisponibilidadTotal() {
        int totalDisponible = 0;
        for (Localidad localidad : localidades) {
            totalDisponible += localidad.consultarDisponibilidad();
        }
        return totalDisponible;
    }

    public int consultarDisponibilidadPorLocalidad(String nombreLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equals(nombreLocalidad)) {
                return localidad.consultarDisponibilidad();
            }
        }
        return 0;
    }

    public double reporteCaja() {
        return ingresosTotales;
    }

    public void salir() {
        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
    }

    // Método añadido para obtener localidades (solo para mejorar la visibilidad en UML)
    public Localidad[] getLocalidades() {
        return localidades;
    }
}
//Marjori Flores (24754) All rights reserved...
