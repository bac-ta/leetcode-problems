package reverse_words_string;

public class ReverseWordsString {
    public String reverseWords(String s) {
        var reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                //end of a word
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                //Check length of reversed world, if > 0 => completed concat the characters to a word
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        var str = "My name is Bac";
        var reverseStr = new ReverseWordsString().reverseWords(str);
    }
}
