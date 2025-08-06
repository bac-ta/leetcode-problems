package algorithm_patterns.prefix_sum;

public class PrefixSum {
    public int calculateInRange(int[] nums, int left, int right) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return calculatePrefixSum(prefixSum, left, right);
    }

    private int calculatePrefixSum(int[] prefixSum, int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        PrefixSum ps = new PrefixSum();
        System.out.println(ps.calculateInRange(new int[]{1, 2, 3, 4, 110, 24, 34, 67}, 3, 6));
    }
}
