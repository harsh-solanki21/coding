package OOP.SingletonClass;

public class  Singleton {

    // a singleton class is a class that can have only one object at a time.

    private static Singleton single_instance = null;

    public String s;

    // Here private constructor is used to restricted to this class itself
    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    // Static method to create instance of Singleton class
    public static Singleton getInstance() {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    public static void main(String args[]) {

        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

        if (x == y && y == z) {
            System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
        }
        else {
            System.out.println("Three objects DO NOT point to the same memory location on the heap");
        }
    }

}
