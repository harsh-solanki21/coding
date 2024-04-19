package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

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
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

}
