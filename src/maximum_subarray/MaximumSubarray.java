package maximum_subarray;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        int endIndex = 0;
        int startIndex, globalMaxStartIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            //Dynamic programing
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            if (maxSoFar > maxEndingHere) {
                endIndex = i - 1;
            } else {
                startIndex = i - 1;
                globalMaxStartIndex = startIndex;
            }
        }

        System.out.println(globalMaxStartIndex);
        System.out.println(endIndex);

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, -1, -110, -2, -4, 55, 57, -7, 4};
        new MaximumSubarray().maxSubArray(nums);
    }

}
