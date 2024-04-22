package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

// Lazy Initialization + Thread Safety
// In this approach, the synchronized block is used inside if condition with an additional check to ensure that only one instance of singleton class is created.

// We can break singleton pattern using Reflection API
// "this" block of code will prevent breaking of singleton pattern from Reflection API

public class DoubleCheckedLocking {

    private static DoubleCheckedLocking instance = null;

    private DoubleCheckedLocking() {
        if (instance != null) {  // this
            throw new RuntimeException("You are trying to break singleton pattern");
        }
    }

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {  // This check is an optimization to avoid the overhead of synchronization once the instance is initialized.
            synchronized (DoubleCheckedLocking.class) {  // This ensures that only one thread can execute this block at a time
                if (instance == null) {  // This is necessary because multiple threads might have passed the first check, and only one should create the instance.
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

}
