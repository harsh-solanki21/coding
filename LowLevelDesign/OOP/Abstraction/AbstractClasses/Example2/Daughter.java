package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example2;

public class Daughter extends Parent2 {

    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I am going to be a Coder");
    }

    @Override
    void partner() {
        System.out.println("I love Iron Man");
    }
}
