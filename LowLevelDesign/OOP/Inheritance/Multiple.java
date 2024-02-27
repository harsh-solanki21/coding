package LowLevelDesign.OOP.Inheritance;

interface Name {
    void printName();
}

interface Age {
    void printAge();
}

interface Detail extends Name, Age {
    void printName();
}

class Child implements Detail {
    @Override
    public void printName() {
        System.out.println("Harsh");
    }

    public void printAge() {
        System.out.println(24);
    }
}


public class Multiple {

    public static void main(String[] args) {
        Child c = new Child();
        c.printName();
        c.printAge();
    }

}
