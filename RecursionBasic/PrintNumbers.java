package RecursionBasic;

public class PrintNumbers {

    static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        print(n - 1);
    }

    static void printReverse(int n) {
        if (n == 0) {
            return;
        }
        printReverse(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;
        print(n);
        System.out.println();
        printReverse(n);
    }

}
