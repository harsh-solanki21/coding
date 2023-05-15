package String;

public class ParenthesesIsBalancedOrNot {

    static boolean isBalanced(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }
        if (count != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s1 = "((()))()()";
        String s2 = "())((())";
        System.out.println(isBalanced(s1));
        System.out.println(isBalanced(s2));
    }

}
