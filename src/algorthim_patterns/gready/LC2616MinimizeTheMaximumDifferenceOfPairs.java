package algorthim_patterns.gready;

import java.util.Arrays;

public class LC2616MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                high = mid - 1; // thử tìm nhỏ hơn
            } else {
                low = mid + 1; // cần tìm lớn hơn
            }
        }

        return result;

    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i += 1;
            }
            if (count >= p) return true;
        }
        return false;
    }
}
