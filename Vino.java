public class Vino {
    private String nombre;
    private int cosecha;
    private String tipo;
    private int dispMin;
    private int dispMax;
    private int dispReal;

    public Vino(String nombre, int cosecha, String tipo, int dispMin, int dispMax, int dispReal) {
        this.nombre = nombre;
        this.cosecha = cosecha;
        this.tipo = tipo;
        this.dispMin = dispMin;
        this.dispMax = dispMax;
        this.dispReal = dispReal;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Cosecha: " + cosecha + "\n" +
               "Tipo: " + tipo + "\n" +
               "Disponibilidad Minima: " + dispMin + "\n" +
               "Disponibilidad Maxima: " + dispMax + "\n" +
               "Disponibilidad Real: " + dispReal;
    }
}
//Marjori Flores (24754) All rights reserved...


