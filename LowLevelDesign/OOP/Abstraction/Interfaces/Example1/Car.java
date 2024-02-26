package LowLevelDesign.OOP.Abstraction.Interfaces.Example1;

public class Car implements Vehicle {

    @Override
    public void Accelerate() {
        System.out.println("Car Acceleration Start");
    }

    @Override
    public void brake() {
        System.out.println("Car using Brake");
    }

    @Override
    public void honk() {
        System.out.println("Car Honk Honk!");
    }

    @Override
    public void startEngine() {
        System.out.println("Car Engine Started");
    }

}
