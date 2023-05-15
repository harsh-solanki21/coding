package Stack;

import java.util.Stack;

public class SmallestNumberFollowingPattern {

    // In the “Form Minimum Number from Given Sequence of D’s and I’s” problem,
    // we have given a pattern containing only I’s and D’s. I for increasing and D for decreasing.
    // Write a program to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

    static String smallestNumberFollowingPattern(String s) {
        if (s.length() > 8) {
            return "-1";
        }

        Stack<Integer> st = new Stack<>();
        String ans = "";
        int n = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'D') {
                st.push(n);
                n++;
            } else {
                st.push(n);
                n++;

                while (st.size() > 0) {
                    ans += st.pop();
                }
            }
        }

        st.push(n);
        while (st.size() > 0) {
            ans += st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "DIDI";  // 21435
        System.out.println(smallestNumberFollowingPattern(s1));

        String s2 = "DIIIDDDI";  // 213487659
        System.out.println(smallestNumberFollowingPattern(s2));

        String s3 = "DDIIDIDD";  // 321465987
        System.out.println(smallestNumberFollowingPattern(s3));

        String s4 = "DIDIDIDIDIIIIIID";  // -1
        System.out.println(smallestNumberFollowingPattern(s4));
    }

}
