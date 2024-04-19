package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton;

// Lazy Initialization
// Single Thread Version (non thread-safe)
// Lazy initialization method to implement Singleton pattern creates the instance in the global access method.

// The below implementation works fine in case of single threaded environment but when it comes to multithreaded systems,
// it can cause issues if multiple threads are inside the if condition at the same time.
// It will destroy the singleton pattern and both threads will get the different instances of singleton class.

public class LazyInitialization {

    // volatile keyword here makes sure that the changes made in one thread are immediately reflect in other threads.
    private static LazyInitialization instance = null;

    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }

}
