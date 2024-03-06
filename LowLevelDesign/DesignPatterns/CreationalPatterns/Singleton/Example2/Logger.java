package LowLevelDesign.DesignPatterns.CreationalPatterns.Singleton.Example2;

// Eager Loading and Not thread safe
//public class Logger {
//
//    private static Logger instance = new Logger();
//
//    private Logger() {
//    }
//
//    public static Logger getInstance() {
//        return instance;
//    }
//
//}


// Lazy Loading and Not thread safe
//public class Logger {
//
//    private static Logger instance = null;
//
//    private Logger() {
//    }
//
//    public static Logger getInstance() {
//        if (instance == null) {
//            instance = new Logger();
//        }
//        return instance;
//    }
//
//}


// Lazy Loading and Thread safe
public class Logger {

    private static volatile Logger instance = null;

    private Logger() {
        if (instance != null) {
            throw new RuntimeException("Please don't try to be smart");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

}
