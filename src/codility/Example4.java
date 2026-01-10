package codility;

public class Example4 {
    public int solution(int[] numbers) {
        int[] countFirst = new int[10];

        for (int num : numbers) {
            int firstNumber = getFirstDigit(num);
            countFirst[firstNumber]++;
        }

        int result = 0;

        for (int num : numbers) {
            int firstNumber = getFirstDigit(num);
            int lastNumber = firstNumber % 10;
            result += countFirst[lastNumber];

            if (firstNumber == lastNumber) {
                result--;
            }
        }
        return result;

    }

    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }
}
