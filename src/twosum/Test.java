package twosum;
public class Test {
    public static int maxSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        // Iterate over all possible combinations of i, j, and k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate the sum ai + 2*aj + 3*ak
                    int sum = arr[i] + 2 * arr[j] + 3 * arr[k];
                    // Update maxSum if we find a larger sum
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 10, 4, 5};
        System.out.println("Maximum sum is: " + maxSum(arr));
    }
}
