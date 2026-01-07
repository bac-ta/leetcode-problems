package codility;

public class Example3 {
    public String solution(String S) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : S.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            }
        }

        //Find larget
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String S = "aaBabcDaA";

        String val = new Example3().solution(S);
        System.out.println(val);
    }
}
