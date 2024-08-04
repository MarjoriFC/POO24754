// Marjori Brisseth Flores Cano (24754) fecha de inicio 01/08/2024 última fecha de modificación 03/08/2024
import java.util.Scanner;

/**
 * Clase que representa el juego PIG.
 */
public class Game {
    private Player player1;
    private Player player2;
    private int currentRound;
    private GameStatistics stats;
    private Dice dice1;
    private Dice dice2;
    private Scanner scanner;

    /**
     * Constructor de la clase Game.
     * 
     * @param player1Name Nombre del jugador 1.
     * @param player2Name Nombre del jugador 2.
     */
    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.currentRound = 1;
        this.stats = new GameStatistics();
        this.dice1 = new Dice(6);
        this.dice2 = new Dice(6);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia el juego y controla la lógica de turnos y decisiones.
     */
    public void start() {
        while (player1.getTotalPoints() < 100 && player2.getTotalPoints() < 100) {
            Player currentPlayer = (currentRound % 2 == 1) ? player1 : player2;
            System.out.println("Es el turno de " + currentPlayer.getName());

            while (true) {
                currentPlayer.rollDice(dice1, dice2);
                System.out.println("Puntos esta ronda: " + currentPlayer.getRoundPoints());
                if (currentPlayer.decideToStop()) {
                    currentPlayer.addRoundPoints();
                    System.out.println(currentPlayer.getName() + " se detiene con " + currentPlayer.getTotalPoints() + " puntos totales.");
                    break;
                }
                System.out.println("¿Continuar lanzando? (si/no)");
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("no")) {
                    currentPlayer.addRoundPoints();
                    System.out.println(currentPlayer.getName() + " se detiene con " + currentPlayer.getTotalPoints() + " puntos totales.");
                    break;
                }
            }

            currentRound++;
        }

        if (player1.getTotalPoints() >= 100) {
            System.out.println("¡" + player1.getName() + " gana!");
            stats.updateStatistics(true);
        } else if (player2.getTotalPoints() >= 100) {
            System.out.println("¡" + player2.getName() + " gana!");
            stats.updateStatistics(false);
        }

        stats.displayStatistics();
    }
}
