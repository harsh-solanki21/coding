package Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.empty() && st.peek() == s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        while (!st.empty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(removeDuplicates("geeksforgeeg"));
        System.out.println(removeDuplicates("caaabbbaacdddd"));
        System.out.println(removeDuplicates("acaaabbbacdddd"));
    }

}
