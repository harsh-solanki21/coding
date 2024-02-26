package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example2;

public class Main {

    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();
        son.normal();

        Parent2 daughter = new Daughter(28);
        daughter.career();
        Parent2.hello();
    }

}
