package String;

public class DecodedStringAtIndex {

    // https://leetcode.com/problems/decoded-string-at-index/description/

    static String decodeAtIndex(String s, int k) {
        long decodedLength = 0; // Total length of the decoded string

        for (char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                // If the character is a digit, update the decoded length accordingly
                decodedLength *= (character - '0');
            } else {
                // If the character is a letter, increment the decoded length
                decodedLength++;
            }
        }

        // Traverse the input string in reverse to decode and find the kth character
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If the character is a digit, adjust the length and k accordingly
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } else {
                // If the character is a letter, check if it's the kth character
                if (k == 0 || decodedLength == k) {
                    return String.valueOf(currentChar); // Return the kth character as a string
                }
                decodedLength--;
            }
        }

        return ""; // Return an empty string if no character is found
    }

    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
//        String s = "ha22";
//        int k = 5;
        System.out.println(decodeAtIndex(s, k));
    }

}
