package algorithm_patterns.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * We use a prefix sum array and a hash map.
 * We store the first index of each remainder. When we see the same remainder again,
 * and the distance is at least two, we know the subarray sum is divisible by k.”
 *
 *
 */
public class LC523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int prefixSum = 0;

        // Map to store the first index where each remainder occurs
        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Update prefix sum with current number
            // Calculate remainder when dividing prefix sum by k
            // If k == 0, just use the prefix sum itself
            int remainder = (k == 0) ? prefixSum : prefixSum % k;
            // If we have seen this remainder before
            if (modIndex.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                int prevIndex = modIndex.get(remainder);
                if (i - prevIndex >= 2) return true;// Found a valid subarray
            } else {
                // Store the first occurrence of this remainder
                modIndex.put(remainder, i);
            }
        }
        return false;
    }
}
