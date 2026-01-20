package codility.example2;

public class MaxDistinctEqualString {
    public String maxDistinct(int N) {
        StringBuilder sb = new StringBuilder();

        int letters = Math.min(26, N);

        while (N % letters != 0) {
            letters--;
        }

        int repeat = N / letters;

        for (int i = 0; i < letters; i++) {
            char c = (char) ('a' + i);
            sb.append(String.valueOf(c).repeat(Math.max(0, repeat)));
        }
        return sb.toString();
    }
}
