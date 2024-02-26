package LowLevelDesign.OOP.Abstraction.Interfaces.Example1;

public class Boat implements Vehicle {

    @Override
    public void startEngine() {
        System.out.println("Boat Engine Started");
    }

    @Override
    public void Accelerate() {
        System.out.println("Boat Acceleration Start");
    }

    @Override
    public void brake() {
        System.out.println("Boat using Brake");
    }

    @Override
    public void honk() {
        System.out.println("Boat Honk Honk!");
    }

}
