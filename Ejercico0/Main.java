public class Main {
    public static void main(String[] args) {
        Horse horse1 = new Horse("Gaz", 5, "Belgian", "Brown", 40);
        Horse horse2 = new Horse("Soap", 3, "Fell", "Black", 50);

        Rider rider1 = new Rider("Ghost", 10, "Male", 1.8f, 75.0f);
        Rider rider2 = new Rider("Price", 5, "Male", 1.6f, 60.0f);

        horse1.gallop();
        horse1.neigh();
        
        horse2.gallop();
        horse2.neigh();
        
        rider1.train();
        rider1.ride();
        
        rider2.train();
        rider2.ride();
    }
}
//Marjori Flores (24754) All rights reserved...