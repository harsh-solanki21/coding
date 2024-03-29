package LowLevelDesign.SOLID.InterfaceSegregation.good;

public class Penguin implements SwimmingCreature, FeatheredCreature {

    String currentLocation;
    int numberOfFeathers;

    public Penguin(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void swim() {
        this.currentLocation = "in the water";
    }

    public void molt() {
        this.numberOfFeathers -= 4;
    }

}
