// Marjori Brisseth Flores Cano (24754) fecha de inicio 01/08/2024 última fecha de modificación 03/08/2024
import java.util.Scanner;

/**
 * Clase que representa a un jugador en el juego.
 */
public class Player {
    private int totalPoints;
    private int roundPoints;
    private String name;
    private Scanner scanner;

    /**
     * Constructor de la clase Player.
     * 
     * @param name Nombre del jugador.
     */
    public Player(String name) {
        this.name = name;
        this.totalPoints = 0;
        this.roundPoints = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lanza los dos dados y actualiza los puntos de la ronda.
     * 
     * @param dice1 Primer dado.
     * @param dice2 Segundo dado.
     */
    public void rollDice(Dice dice1, Dice dice2) {
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        System.out.println(name + " lanzó: " + roll1 + " y " + roll2);

        if (roll1 == 1 || roll2 == 1) {
            roundPoints = 0; // Perdió los puntos
            System.out.println(name + " sacó un 1. Todos los puntos de la ronda se pierden.");
        } else {
            roundPoints += roll1 + roll2;
        }
    }

    /**
     * Decide si el jugador debe detenerse basado en los puntos de la ronda.
     * 
     * @return true si el jugador decide detenerse, false en caso contrario.
     */
    public boolean decideToStop() {
        if (roundPoints >= 20) {
            System.out.println(name + ", tienes " + roundPoints + " puntos esta ronda. ¿Deseas detenerte? (si/no)");
            String decision = scanner.nextLine();
            return decision.equalsIgnoreCase("si");
        }
        return false;
    }

    /**
     * Obtiene los puntos de la ronda actual.
     * 
     * @return Puntos de la ronda actual.
     */
    public int getRoundPoints() {
        return roundPoints;
    }

    /**
     * Añade los puntos de la ronda al total del jugador.
     */
    public void addRoundPoints() {
        totalPoints += roundPoints;
        roundPoints = 0;
    }

    /**
     * Obtiene los puntos totales del jugador.
     * 
     * @return Puntos totales del jugador.
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return Nombre del jugador.
     */
    public String getName() {
        return name;
    }
}


