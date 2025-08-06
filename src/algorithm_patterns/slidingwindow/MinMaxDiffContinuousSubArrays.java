package algorithm_patterns.slidingwindow;

public class MinMaxDiffContinuousSubArrays {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) return -1;

        double minSum = Double.POSITIVE_INFINITY;
        double maxSum = nums[0];
        double windowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i + 1 < k) continue;
            windowSum = windowSum / k;
            minSum = Math.min(minSum, windowSum);
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= nums[i + 1 - k];
        }

        return maxSum / k - minSum / k;

    }
}
