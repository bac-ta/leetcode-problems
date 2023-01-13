package maximum_subarray;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            //Dynamic programing

            if (nums[i] > maxEndingHere + nums[i]) {
                maxEndingHere = nums[i];
                startIndex = i;
            } else {
                maxEndingHere = nums[i] + maxEndingHere;
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                endIndex = i;
            }

        }
        System.out.println(startIndex);
        System.out.println(endIndex);


        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, -1, -110, -2, 1111, -4, 55, 57, -7, 4};
        new MaximumSubarray().maxSubArray(nums);
    }

}
