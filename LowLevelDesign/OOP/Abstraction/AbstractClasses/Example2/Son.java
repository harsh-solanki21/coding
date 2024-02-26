package LowLevelDesign.OOP.Abstraction.AbstractClasses.Example2;

public class Son extends Parent1 {

    public Son(int age) {
        super(age);
    }

    @Override
    void normal() {
        super.normal();
    }

    @Override
    void career() {
        System.out.println("I am going to be a Doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Pepper Potts");
    }
}
