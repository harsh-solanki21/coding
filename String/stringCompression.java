package String;

public class stringCompression {

    static int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;

        if (chars.length == 1)
            return 1;

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            chars[index++] = chars[i];
            if (count > 1) {
                String countVal = String.valueOf(count);
                for (int j = 0; j < countVal.length(); j++) {
                    chars[index++] = countVal.charAt(j);
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd'};
        System.out.println(compress(chars));
    }

}
