package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

public class Main {

    // Singleton class never accepts parameters.
    // If it accepts parameter, then it becomes factory. So avoid it.

    // Ways to break Singleton pattern:
    // 1. Reflection API
    // 2. Deserialization
    // 3. Cloning

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
