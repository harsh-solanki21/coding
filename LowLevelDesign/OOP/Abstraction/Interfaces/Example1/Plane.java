package LowLevelDesign.OOP.Abstraction.Interfaces.Example1;

public class Plane implements Vehicle {

    @Override
    public void Accelerate() {
        System.out.println("Plane Acceleration Start");
    }

    @Override
    public void brake() {
        System.out.println("Plane using Brake");
    }

    @Override
    public void honk() {
        System.out.println("Plane Honk Honk!");
    }

    @Override
    public void startEngine() {
        System.out.println("Plane Engine Started");
    }

}
