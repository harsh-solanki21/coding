package math;

public class NewtonRaphsonMethod {

    // Newton Raphson Method to find SQRT
    // root = (x + (n / x)) / 2                 Sqrt(n) = (x + (n / x)) / 2
    // Here, x = sqrt that you have assumed
    // Time Complexity: O(log n * f(n))

    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }

    static double sqrt(double n) {
        double x = n;
        double root;
        while(true) {
            root = 0.5 * (x + (n/x));
            if(Math.abs(root - x) < 1) {
                break;
            }
            x = root;
        }
        return root;
    }

}
