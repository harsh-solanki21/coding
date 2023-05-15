package HashMap;

import java.util.HashMap;

public class HighestFrequencyCharacter {

    static char highestFrequencyCharacter(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                int freq = hm.get(ch);
                hm.put(ch, freq + 1);
            } else {
                hm.put(ch, 1);
            }
        }

        char maxFrequencyChar = s.charAt(0);
        for (Character key : hm.keySet()) {
            if (hm.get(key) > hm.get(maxFrequencyChar)) {
                maxFrequencyChar = key;
            }
        }

        return maxFrequencyChar;
    }

    public static void main(String[] args) {
        String s = "babcccdbabcccd";
        System.out.println(highestFrequencyCharacter(s));
    }

}
