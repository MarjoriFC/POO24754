package main.ejercicio1;

import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        Localidad[] localidades = {
            new Localidad("Localidad 1", 100, 100.0),
            new Localidad("Localidad 5", 100, 500.0),
            new Localidad("Localidad 10", 100, 1000.0)
        };

        SistemaVentaBoletos sistema = new SistemaVentaBoletos(localidades);
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    realizarCompra(scanner, sistema);
                    break;

                case 2:
                    consultarDisponibilidadTotal(sistema);
                    break;

                case 3:
                    consultarDisponibilidadPorLocalidad(scanner, sistema);
                    break;

                case 4:
                    reporteCaja(sistema);
                    break;

                case 5:
                    sistema.salir();
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Comprar boleto");
        System.out.println("2. Consultar disponibilidad total");
        System.out.println("3. Consultar disponibilidad por localidad");
        System.out.println("4. Reporte de caja");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    private static void realizarCompra(Scanner scanner, SistemaVentaBoletos sistema) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cantidad de boletos: ");
        int cantidad = scanner.nextInt();
        System.out.print("Presupuesto maximo: ");
        double presupuesto = scanner.nextDouble();
        System.out.print("Selecciona la localidad (0-2): ");
        int localidadSeleccionada = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        sistema.comprarBoleto(nombre, email, cantidad, presupuesto, localidadSeleccionada);
    }

    private static void consultarDisponibilidadTotal(SistemaVentaBoletos sistema) {
        System.out.println("Disponibilidad total: " + sistema.consultarDisponibilidadTotal());
    }

    private static void consultarDisponibilidadPorLocalidad(Scanner scanner, SistemaVentaBoletos sistema) {
        System.out.print("Nombre de la localidad: ");
        String nombreLocalidad = scanner.nextLine();
        System.out.println("Disponibilidad en " + nombreLocalidad + ": " + sistema.consultarDisponibilidadPorLocalidad(nombreLocalidad));
    }

    private static void reporteCaja(SistemaVentaBoletos sistema) {
        System.out.println("Reporte de caja: $" + sistema.reporteCaja());
    }
}

//Marjori Flores (24754) All rights reserved...