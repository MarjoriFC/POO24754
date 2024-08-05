import java.util.Scanner;
import java.util.Random;

public class MainBingoU {
    private static final double COSTO_JUEGO = 12.00;
    private static final double SALDO_INICIAL = 48.00;
    private static double saldoActual;
    private static double ganancias;

    public static void main(String[] args) {
        saldoActual = SALDO_INICIAL;
        ganancias = 0;
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Jugar");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Validar entrada del usuario
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada no válida. Por favor, seleccione una opción válida: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            
            procesarOpcion(opcion);
        } while (opcion != 3);
        scanner.close();
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Opción 1 seleccionada: Jugar");
                jugar();
                break;
            case 2:
                System.out.println("Opción 2 seleccionada: Consultar saldo");
                consultarSaldo();
                break;
            case 3:
                System.out.println("Opción 3 seleccionada: Salir");
                System.out.println("Gracias por jugar. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private static void jugar() {
        if (saldoActual < COSTO_JUEGO) {
            System.out.println("No tiene saldo suficiente para jugar.");
            return;
        }

        saldoActual -= COSTO_JUEGO;

        int[] numeros = new int[3];
        for (int i = 0; i < 3; i++) {
            numeros[i] = generarNumeroAleatorio();
            System.out.println("Número " + (i + 1) + ": " + numeros[i]);
        }

        int cantidadPares = 0;
        int sumaPares = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                cantidadPares++;
                sumaPares += numero;
            }
        }

        if (cantidadPares >= 2) {
            double premio = calcularPremio(numeros);
            ganancias += premio;
            System.out.printf("¡Felicidades! Ha ganado Q%.2f%n", premio);
        } else {
            System.out.println("Gracias por su participación.");
        }
    }

    private static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(901) + 100;
    }

    private static double calcularPremio(int[] numeros) {
        int[] pares = new int[2];
        int index = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0 && index < 2) {
                pares[index++] = numero;
            }
        }

        int sumaPares = pares[0] + pares[1];
        if (pares[0] > 700 && pares[1] > 700) {
            return sumaPares * 0.10;
        } else if (pares[0] >= 500 && pares[0] <= 700 && pares[1] >= 500 && pares[1] <= 700) {
            return sumaPares * 0.20;
        } else if ((pares[0] > 500 && pares[1] <= 500) || (pares[1] > 500 && pares[0] <= 500)) {
            return sumaPares * 0.15;
        } else if (pares[0] < 500 && pares[1] < 500) {
            return sumaPares * 0.25;
        }
        return 0;
    }

    private static void consultarSaldo() {
        double saldoEnDolares = saldoActual / 7.75; // Asumiendo el tipo de cambio de 1 USD = 7.75 Q
        System.out.printf("Saldo actual: Q%.2f (USD %.2f)%n", saldoActual, saldoEnDolares);
        System.out.printf("Ganancias acumuladas: Q%.2f (USD %.2f)%n", ganancias, ganancias / 7.75);
    }
}

