package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnakeCaseToCamelCase {

    static String stringFormatter(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        Pattern pattern = Pattern.compile("(?<=[a-zA-Z])_([a-zA-Z])");

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            StringBuilder formattedWord = new StringBuilder();
            while (matcher.find()) {
                matcher.appendReplacement(formattedWord, matcher.group(1).toUpperCase());
            }
            matcher.appendTail(formattedWord);
            ans.append(formattedWord).append(" ");
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "This is __the best_line for _formatting the_sentence_";
        String s2 = "__somehow__ this is also_one__ of __the_example";
        String s3 = "this_ is __the_example__";

        System.out.println(stringFormatter(s1));
        System.out.println(stringFormatter(s2));
        System.out.println(stringFormatter(s3));
    }

}
