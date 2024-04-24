package LowLevelDesign.DesignPatterns.StructuralPatterns.Decorator;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println("Adding features of Luxury Car.");
    }


}
