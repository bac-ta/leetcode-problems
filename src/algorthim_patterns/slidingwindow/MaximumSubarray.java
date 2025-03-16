package algorthim_patterns.slidingwindow;

public class MaximumSubarray {
    public int calcMaximumSubarray(int[] array, int k) {
        if (array.length < k) return -1;

        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        for (int i = 0; i < array.length; i++) {
            windowSum += array[i];
            if (i + 1 < k) continue;

            maxSum = Math.max(maxSum, windowSum);
            windowSum -= array[i - k + 1];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        var maxSum = new MaximumSubarray().calcMaximumSubarray(arr, k);
        System.out.printf("max sum: " + maxSum);
    }
}
