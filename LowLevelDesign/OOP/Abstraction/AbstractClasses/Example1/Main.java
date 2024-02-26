package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example1;

public class Main {

    public static void main(String[] args) {
        Car s1 = new Audi("Red", 2.2);
        Car s2 = new Mercedes("Yellow", 2, 4);
        System.out.println();

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

}
