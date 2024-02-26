package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example1;

public class Mercedes extends Car {

    double distance;
    double time;

    public Mercedes(String color, double distance, double time) {
        super(color);
        System.out.println("Mercedes constructor called");
        this.distance = distance;
        this.time = time;
    }

    @Override
    double speed() {
        return distance / time;
    }

    @Override
    public String toString() {
        return "Mercedes color is: " + super.color + ", speed is : " + speed();
    }

}
