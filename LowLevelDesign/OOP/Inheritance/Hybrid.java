package LowLevelDesign.OOP.Inheritance;

interface CompetitiveCoder {
    void competitive();
}

interface NormalCoder {
    void normal();
}

class Parent {
    void greeting() {
        System.out.println("Hello Ninja!!");
    }
}

// First child class
class Child1 extends Parent implements NormalCoder {
    public void normal() {
        System.out.println("Hey, Child1 you can start with the normal coding.");
    }
}

// Second child class
class Child2 extends Parent implements NormalCoder, CompetitiveCoder {
    public void normal() {
        System.out.println("Hey, Child2 first you should start with normal coding.");
    }

    public void competitive() {
        System.out.println("Hey, Child2 now you can start with competitive programming.");
    }
}

public class Hybrid {

    public static void main(String[] args) {
        Child1 c1 = new Child1();
        c1.greeting();
        c1.normal();

        System.out.println();

        Child2 c2 = new Child2();
        c2.greeting();
        c2.normal();
        c2.competitive();
    }

}
