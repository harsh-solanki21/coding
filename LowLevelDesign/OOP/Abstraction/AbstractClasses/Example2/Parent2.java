package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example2;

public abstract class Parent2 {

    int age;
    final int VALUE;

    public Parent2(int age) {
        this.age = age;
        VALUE = 32456789;
    }

    static void hello(){
        System.out.println("Hello from 2nd Parent");
    }

    void normal() {
        System.out.println("This is a normal method form 2nd Parent");
    }

    abstract void career();
    abstract void partner();
}
