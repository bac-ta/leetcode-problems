package reverse_words_string;

/**
 * Input string does NOT contain leading or trailing spaces and the words are separated
 * by a single space
 */
public class ReverseWordsString2 {
    public void reverseWords(char[] s) {
        reverseCharacter(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverseCharacter(s, i, j);
                i = j + 1;
            }
        }
        System.out.println("string after reversed is: ");
        System.out.println(s);
    }

    private void reverseCharacter(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }

    }

    public static void main(String[] args) {
        char[] s = {'t', 'o', 'i', ' ', 'l', 'a', ' ', 'B', 'a', 'c'};
        var instance = new ReverseWordsString2();
        instance.reverseWords(s);
    }
}
