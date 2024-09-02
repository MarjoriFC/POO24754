//Majori Brisseth Flores Cano all rights reserved
//Fecha de inicio: 21/08/2024
//Última modificación: 22/08/2024
//Programa que gestiona la reserva de salones en un centro de eventos. 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Salon {
    private int num;
    private int capacidad;
    private double costoHora;
    private List<Equipo> equipos;

    public Salon(int num, int capacidad, double costoHora) { 
        this.num = num;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.equipos = new ArrayList<>();
    }

    public int getNum() {
        return num;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    @Override
    public String toString() {
        return "Salon{" + "num=" + num + ", capacidad=" + capacidad +
                ", costoHora=" + costoHora + '}';
    }
}

class Evento {
    private String encargado;
    private String nombre;
    private String tipo;
    private String fecha;
    private String horario;
    private Salon salon;
    private List<Equipo> equipos;

    public Evento(String encargado, String nombre, String tipo, String fecha, String horario) {
        this.encargado = encargado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.horario = horario;
        this.equipos = new ArrayList<>();
    }

    public void asignarSalon(Salon salon) {
        this.salon = salon;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Evento{" + "encargado=" + encargado + ", nombre=" + nombre +
                ", tipo=" + tipo + ", fecha=" + fecha + ", horario=" + horario +
                ", salon=" + salon + '}';
    }
}

class Equipo {
    private String nombre;
    private String numSerie;
    private String fechaCompra;
    private Empleado responsable;

    public Equipo(String nombre, String numSerie, String fechaCompra, Empleado responsable) {
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.fechaCompra = fechaCompra;
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", numSerie=" + numSerie +
                ", fechaCompra=" + fechaCompra + ", responsable=" + responsable + '}';
    }
}

class Empleado {
    private String nombre;
    private String numID;

    public Empleado(String nombre, String numID) {
        this.nombre = nombre;
        this.numID = numID;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", numID=" + numID + '}';
    }
}

class CentroEventos {
    private List<Salon> salones;
    private List<Evento> espera;
    private List<Evento> reservados;

    public CentroEventos() {
        this.salones = new ArrayList<>();
        this.espera = new ArrayList<>();
        this.reservados = new ArrayList<>();
    }

    public void agregarSalon(Salon salon) {
        salones.add(salon);
    }

    public void recibirReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del evento:");
        System.out.print("Encargado: ");
        String encargado = scanner.nextLine();
        System.out.print("Nombre del evento: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de evento: ");
        String tipo = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("Horario: ");
        String horario = scanner.nextLine();

        Evento evento = new Evento(encargado, nombre, tipo, fecha, horario);

        Salon salonAsignado = null;
        for (Salon salon : salones) {
            if ((salon.getCapacidad() < 100 && !tipo.equals("VIP")) || 
                (salon.getCapacidad() >= 100 && tipo.equals("VIP"))) {
                salonAsignado = salon;
                break;
            }
        }

        if (salonAsignado != null) {
            evento.asignarSalon(salonAsignado);
            reservados.add(evento);
            System.out.println("Salon asignado con exito.");
        } else {
            espera.add(evento);
            System.out.println("No hay salones disponibles. El evento ha sido añadido a la lista de espera.");
        }
    }

    public void consultarEspera() {
        System.out.println("Lista de Espera:");
        for (Evento evento : espera) {
            System.out.println(evento.getNombre() + " - " + evento.getFecha() + " - " + evento.getTipo());
        }
    }

    public void generarReporte() {
        System.out.println("Reporte de Eventos Reservados:");
        for (Evento evento : reservados) {
            System.out.println(evento);
        }
    }
}

public class GestionCentroEventos {
    public static void main(String[] args) {
        CentroEventos centro = new CentroEventos();

        centro.agregarSalon(new Salon(1, 50, 100.0));
        centro.agregarSalon(new Salon(2, 80, 150.0));
        centro.agregarSalon(new Salon(3, 200, 300.0));
        centro.agregarSalon(new Salon(4, 500, 500.0));

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu de opciones:");
            System.out.println("1. Recibir solicitud de reserva");
            System.out.println("2. Consultar lista de espera");
            System.out.println("3. Generar reporte de eventos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    centro.recibirReserva();
                    break;
                case 2:
                    centro.consultarEspera();
                    break;
                case 3:
                    centro.generarReporte();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}

