package LowLevelDesign.OOP.Polymorphism;

class Animal {
    public void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog eats meat");
    }
}

class Puppy extends Dog {
    public void eat() {
        System.out.println("Puppy drinks milk");
    }
}

public class Overriding {

    public static void main(String[] args) {
        Animal a1, a2, a3;

        System.out.println("-----No Dynamic method dispatch-----");
        a1 = new Animal();
        a1.eat();

        System.out.println("\n-----Dynamic method dispatch-----");
        a2 = new Dog();
        a3 = new Puppy();

        a2.eat();
        a3.eat();
    }

}
