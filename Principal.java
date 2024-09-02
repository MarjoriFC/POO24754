//Marjori Brisseth Flores Cano (24754) POO - 50
//Este programa gestiona proyectos y contratistas en una empresa de construcción, 
//permitiendo registrar información clave, analizar estadísticas y manejar múltiples ubicaciones.
// Fecha de Creación: 28 de agosto de 2024
//Fecha de Última Modificación: 30 de agosto de 2024

import java.util.ArrayList;
import java.util.Date;

// Clase Proyecto
class Proyecto {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFinEstimada;
    private double presupuesto;
    private double presupuestoUtilizado;

    public Proyecto(int id, String nombre, Date fechaInicio, Date fechaFinEstimada, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.presupuesto = presupuesto;
        this.presupuestoUtilizado = 0.0;
    }

    public void agregarGasto(double monto) {
        this.presupuestoUtilizado += monto;
    }

    public double calcularProgreso() {
        // Lógica para calcular el progreso basado en fechas
        return 0.0;
    }

    public double calcularPresupuestoUtilizado() {
        return (this.presupuestoUtilizado / this.presupuesto) * 100;
    }

    // Getters y setters para los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public double getPresupuesto() {
        return presupuesto;
    }
}

// Clase Contratista
class Contratista {
    private int id;
    private String nombre;
    private String especialidad;
    private double montoPagado;

    public Contratista(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.montoPagado = 0.0;
    }

    public void actualizarMontoPagado(double monto) {
        this.montoPagado += monto;
    }

    // Getters y setters para los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getMontoPagado() {
        return montoPagado;
    }
}

// Clase Ubicacion
class Ubicacion {
    private String nombre;
    private ArrayList<Proyecto> proyectos;

    public Ubicacion(String nombre) {
        this.nombre = nombre;
        this.proyectos = new ArrayList<>();
    }

    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public double obtenerGastoTotal() {
        double gastoTotal = 0.0;
        for (Proyecto proyecto : proyectos) {
            gastoTotal += proyecto.calcularPresupuestoUtilizado();
        }
        return gastoTotal;
    }

    // Getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
}

// Clase SistemaGestion
class SistemaGestion {
    private ArrayList<Ubicacion> ubicaciones;
    private ArrayList<Contratista> contratistas;

    public SistemaGestion() {
        this.ubicaciones = new ArrayList<>();
        this.contratistas = new ArrayList<>();
    }

    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicaciones.add(ubicacion);
    }

    public void agregarContratista(Contratista contratista) {
        contratistas.add(contratista);
    }

    public void cargarDatosDesdeCSV(String archivo) {
        // Lógica para cargar datos desde un archivo CSV
    }

    public void analizarEstadisticas() {
        // Lógica para analizar estadísticas de gastos, contratistas frecuentes, etc.
    }

    // Getters y setters para los atributos
    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public ArrayList<Contratista> getContratistas() {
        return contratistas;
    }
}

// Clase Principal 

/**
 *
 * @author Marjori
 */
public class Principal {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

        Ubicacion ubicacion1 = new Ubicacion("Ciudad 1");
        Proyecto proyecto1 = new Proyecto(1, "Edificio A", new Date(), new Date(), 1000000);
        Contratista contratista1 = new Contratista(1, "Juan Perez", "Albañil");

        ubicacion1.agregarProyecto(proyecto1);
        sistema.agregarUbicacion(ubicacion1);
        sistema.agregarContratista(contratista1);

        sistema.analizarEstadisticas();
    }
}

