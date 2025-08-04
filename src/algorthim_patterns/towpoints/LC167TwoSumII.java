package algorthim_patterns.towpoints;

public class LC167TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) right--;
            else left++;
        }
        return new int[0];
    }
}
