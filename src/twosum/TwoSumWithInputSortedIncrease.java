package twosum;

public class TwoSumWithInputSortedIncrease {
    public int[] twoSum(int[] numbers, int sum) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int currentSum = numbers[i] + numbers[j];
            if (currentSum > sum)
                j--;
            else if (currentSum < sum)
                i++;
            else
                return new int[]{i, j};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {-100, -89, -1, 3, 5, 15, 20, 67};
        int sum = -33;
        int[] twoSum = new TwoSumWithInputSortedIncrease().twoSum(numbers, sum);
        if (twoSum.length > 0) {
            System.out.println(twoSum[0]);
            System.out.println(twoSum[1]);
        }
    }
}
