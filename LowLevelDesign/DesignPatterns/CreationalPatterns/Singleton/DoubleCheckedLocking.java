package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

// In this approach, the synchronized block is used inside if condition with an additional check to ensure that only one instance of singleton class is created.

public class DoubleCheckedLocking {

    private static DoubleCheckedLocking instance = null;

    private DoubleCheckedLocking() {
        if (instance != null) {
            throw new RuntimeException("Please don't try to be smart");
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
