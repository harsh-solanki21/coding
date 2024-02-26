package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example1;

public class Audi extends Car {
    double speed;

    public Audi(String color, double speed) {
        super(color);
        System.out.println("Audi constructor called");
        this.speed = speed;
    }

    @Override
    double speed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Audi Color : " + super.color + ", speed : " + speed();
    }

}
