package String;

public class permutationsIterative {

//    Time Complexity :
//    O(n! * n) = O(n!)
//    We are looping from 1 to n! in the outer loop. And in the inner loop, we are performing some operations which are running n times.
//    Here n represents the length of the string. Thus, we have a total time complexity of O(n! * n).
//
//    SPACE COMPLEXITY :
//    O(n)
//    For space complexity, we are not storing the permutations, but we are using a StringBuilder for the string operations.
//    So the auxiliary space will remain O(n).O(n).

    static void solution(String str) {
        int len = str.length();
        int n = factorial(len);

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;

            for (int j = len; j >= 1; j--) {
                int q = temp / j;
                int r = temp % j;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
    }

    static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        String str = "abc";
        solution(str);
    }

}
