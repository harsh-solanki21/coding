package LowLevelDesign.OOP.Abstraction.Interfaces.Example1;

public class Main {

    public static void main(String[] args) {
        Boat b = new Boat();
        b.startEngine();
        b.Accelerate();
        b.brake();
        System.out.println();

        Car c = new Car();
        c.startEngine();
        c.Accelerate();
        c.honk();
        System.out.println();

        Plane p = new Plane();
        p.startEngine();
        p.Accelerate();
        p.honk();
    }

}
