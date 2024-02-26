package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example2;

public abstract class Parent1 {

    int age;
    final int VALUE;

    public Parent1(int age) {
        this.age = age;
        VALUE = 32456789;
    }

    static void hello(){
        System.out.println("Hi from 1st Parent");
    }

    void normal() {
        System.out.println("This is a normal method form 1st Parent");
    }

    abstract void career();
    abstract void partner();
}
