package String;

public class BasicCompression {

    // Compression 1
    static String compression(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int count = 0;
        char current = s.charAt(0);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == current) {
                count++;
            } else {
                ans.append(current).append(count);
                current = ch;
                count = 1;
            }
        }
        ans.append(current).append(count);
        return ans.toString();
    }


    // Compression 2
    static int compress(char[] chars) {
        int index = 0, count = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[index++] = chars[i];
                if (count != 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                count = 0;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        String s = "aabcccccaaah";
//        System.out.println(compression(s));

        char[] chars = {'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'a', 'a', 'a', 'h'};
        System.out.println(compress(chars));
    }

}
