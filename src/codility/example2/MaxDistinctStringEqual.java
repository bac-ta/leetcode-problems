package codility.example2;

public class MaxDistinctStringEqual {
    public String solution(int n) {
        var sb = new StringBuilder();

        int letters = Math.min(26, n); //26 alphabets
        while (n % letters != 0) {
            letters--;
        }
        int repeat = n / letters;

        for (int i = 0; i < letters; i++) {
            var character = (char) (i + 'a');

            int currentCharacterRepeat = Math.max(0, repeat);
            sb.append(String.valueOf(character).repeat(currentCharacterRepeat));

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var instance = new MaxDistinctStringEqual();
        System.out.println("result with n = 3: " + instance.solution(3));
        System.out.println("result with n = 5: "+ instance.solution(5));
        System.out.println("result with n = 30: "+ instance.solution(30));
        System.out.println("result with n = 200000: "+ instance.solution(200000));
    }
}
