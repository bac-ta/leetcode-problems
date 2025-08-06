package algorithm_patterns.slidingwindow;

import java.util.Arrays;

public class LC209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                min = Math.min(min, right - left + 1);
                windowSum -= nums[left++];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int[] minSubArrayWithSum(int target, int[] nums) {
        int windowSum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = -1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                windowSum -= nums[left++];
                left++;
            }
        }
        if (start == -1) return new int[0];
        return Arrays.copyOfRange(nums, start, start + min);
    }
}
