package codility.example3;

public class AlphabeticallyLargestLetter {
    public String solution(String S) {
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];

        for (char c : S.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) return String.valueOf((char) (i + 'a'));
        }
        return "No";
    }
}
