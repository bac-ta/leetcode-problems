package reverse_words_string;

public class ReverseWordsStringBestSolution {
    public void reverseWords(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        new ReverseWordsStringBestSolution().reverseWords(s);
        System.out.println(s);
    }
}
