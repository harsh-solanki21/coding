package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

// Thread Safe
// By adding a synchronized keyword to getInstance, we force every thread to wait for its turn before it can enter the method.
// This will avoid two threads accessing the static method at the same time.
// Synchronizing a method could decrease the performance.

// To avoid this extra overhead every time, double-checked locking principle is used.

public class ThreadSafe {

    private static ThreadSafe instance;

    private ThreadSafe() {
    }

    public static synchronized ThreadSafe getInstance() {
        if (instance == null) {
            instance = new ThreadSafe();
        }
        return instance;
    }

}
