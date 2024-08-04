// Marjori Brisseth Flores Cano (24754) fecha de inicio 01/08/2024 última fecha de modificación 03/08/2024
/**
 * Clase que maneja las estadísticas del juego.
 */
public class GameStatistics {
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;

    /**
     * Constructor de la clase GameStatistics.
     */
    public GameStatistics() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    /**
     * Actualiza las estadísticas después de un juego.
     * 
     * @param won true si el juego fue ganado, false si fue perdido.
     */
    public void updateStatistics(boolean won) {
        gamesPlayed++;
        if (won) {
            gamesWon++;
        } else {
            gamesLost++;
        }
    }

    /**
     * Muestra las estadísticas de los juegos jugados.
     */
    public void displayStatistics() {
        double winPercentage = (gamesPlayed == 0) ? 0 : (double) gamesWon / gamesPlayed * 100;
        System.out.println("Juegos Jugados: " + gamesPlayed);
        System.out.println("Juegos Ganados: " + gamesWon);
        System.out.println("Juegos Perdidos: " + gamesLost);
        System.out.println("Porcentaje de Victorias: " + winPercentage + "%");
    }
}

