package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton.Example2;

public class Main {

    public static void main(String[] args) {

        Logger singletonObj = Logger.getInstance();
        System.out.println(singletonObj);

        Logger singletonObj2 = Logger.getInstance();
        System.out.println(singletonObj2);

    }

}
