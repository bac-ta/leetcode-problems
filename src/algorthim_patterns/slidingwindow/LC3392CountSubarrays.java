package algorthim_patterns.slidingwindow;

public class LC3392CountSubarrays {
    public int countSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] + arr[i + 2] == 0.5 * arr[i + 1]) count++;
        }
        return count;
    }
}
