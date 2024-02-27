package LowLevelDesign.OOP.Polymorphism;

class AddNumbers {

    public int addition(int x, int y) {
        return x + y;
    }

    public int addition(int x, int y, int z) {
        return x + y + z;
    }

    public int addition(double x, int y) {
        return (int) x + y;
    }
}

public class Overloading {

    public static void main(String[] args) {
        AddNumbers add = new AddNumbers();
        System.out.println(add.addition(1, 2));
        System.out.println(add.addition(1, 2, 3));
        System.out.println(add.addition(3.54, 4));
    }

}
