// Marjori Brisseth Flores Cano (24754) fecha de inicio 01/08/2024 última fecha de modificación 03/08/2024
import java.util.Random;

/**
 * Clase que representa un dado.
 */
public class Dice {
    private int sides;

    /**
     * Constructor de la clase Dice.
     * 
     * @param sides Número de lados del dado.
     */
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Lanza el dado y devuelve un valor aleatorio entre 1 y el número de lados.
     * 
     * @return Valor del lanzamiento del dado.
     */
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }
}
