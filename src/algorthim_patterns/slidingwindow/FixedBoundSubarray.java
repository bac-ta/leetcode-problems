package algorthim_patterns.slidingwindow;

public class FixedBoundSubarray {
    public int numOfSubarrays(int [] nums, int minK, int maxK) {
        int count = 0;
        int lastMin = -1;
        int lastMax = -1;
        int left = -1; // phần tử vi phạm gần nhất

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] < minK || nums[right] > maxK) {
                left = right;
            }
            if (nums[right] == minK) {
                lastMin  = right;
            }
            if (nums[right] == maxK) {
                lastMax = right;
            }

            int validLeft = Math.min(lastMin, lastMax);
            if (validLeft > left) {
                count += validLeft - left;
            }

        }
        return count;
    }
}
