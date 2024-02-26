package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example1;

abstract class Car {

    String color;

    abstract double speed();

    abstract public String toString();

    public Car(String color) {
        System.out.println("Car constructor called");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
