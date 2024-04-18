package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

public class Main {

    public static void main(String[] args) {
        EagerInitialization eager = EagerInitialization.getInstance();

        LazyInitialization lazy1 = LazyInitialization.getInstance();
        LazyInitialization lazy2 = LazyInitialization.getInstance();
        LazyInitialization lazy3 = LazyInitialization.getInstance();

        ThreadSafe threadSafe = ThreadSafe.getInstance();

        DoubleCheckedLocking lock = DoubleCheckedLocking.getInstance();

        if (lazy1 == lazy2 && lazy2 == lazy3) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }

}
