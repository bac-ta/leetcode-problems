package codility.example7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSumSubarrayWithEqualEndpoints {
    public int solution(int[] A) {
        int n = A.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        System.out.println("print prefix:");
        System.out.println(Arrays.toString(prefix));

        Map<Integer, Long> firstPrefix = new HashMap<>();
        long result = -1;
        for (int i = 0; i < n; i++) {
            int value = A[i];
            if (!firstPrefix.containsKey(value)) {
                firstPrefix.put(value, prefix[i]);
            } else {
                long recentSum = prefix[i + 1] - firstPrefix.get(value);
                result = Math.max(result, recentSum);
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 1, 6, 6, 9, 9};
        new MaximumSumSubarrayWithEqualEndpoints().solution(A);

    }
}
