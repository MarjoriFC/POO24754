public class Rider {
    private String name;
    private int experience;
    private String gender;
    private float height;
    private float weight;

    public Rider(String name, int experience, String gender, float height, float weight) {
        this.name = name;
        this.experience = experience;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void train() {
        System.out.println(name + " is training for the next competition.");
    }

    public void ride() {
        System.out.println(name + " is riding a horse for fun.");
    }
}
//Marjori Flores (24754)