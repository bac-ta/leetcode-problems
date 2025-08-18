package algorithm_patterns.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class LC523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int prefixSum = 0;

        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = (k == 0) ? prefixSum : prefixSum % k;
            if (modIndex.containsKey(remainder)) {
                int prevIndex = modIndex.get(remainder);
                if (i - prevIndex >= 2) return true;
            } else {
                modIndex.put(remainder, i);
            }
        }
        return false;
    }
}
