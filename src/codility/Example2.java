package codility;

public class Example2 {
    public String solution(int N) {
        StringBuilder builder = new StringBuilder();

        int letters = Math.min(26, N);

        while (N % letters != 0) {
            letters--;
        }

        int repeat = N / letters;

        for (int i = 0; i < letters; i++) {
            char c = (char) ('a' + i);
            builder.append(String.valueOf(c).repeat(Math.max(0, repeat)));
        }

        return builder.toString();
    }
}
