public class Horse {
    private String name;
    private int age;
    private String breed;
    private String color;
    private int speed;

    public Horse(String name, int age, String breed, String color, int speed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void gallop() {
        System.out.println(name + " is galloping at speed " + speed + " Impressive, right?");
    }

    public void neigh() {
        System.out.println(name + " eat a lot.");
    }
}
//Marjori Flores (24754)