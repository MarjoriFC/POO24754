// Marjori Brisseth Flores Cano (24754) fecha de inicio 01/08/2024 última fecha de modificación 03/08/2024
import java.util.Scanner;

/**
 * Clase principal que inicia el juego.
 */
public class Mineping {
    /**
     * Método principal que inicia el juego.
     * 
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del Jugador 1:");
        String player1Name = scanner.nextLine();
        System.out.println("Ingresa el nombre del Jugador 2:");
        String player2Name = scanner.nextLine();

        Game game = new Game(player1Name, player2Name);
        game.start();
    }
}

