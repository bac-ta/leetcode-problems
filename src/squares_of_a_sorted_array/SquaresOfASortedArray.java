package squares_of_a_sorted_array;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[left]) > arr[right]) {
                res[i] = arr[left] * arr[left];
                left++;
            } else {
                res[i] = arr[right] * arr[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var res = new SquaresOfASortedArray().sortedSquares(new int[]{-4, 0, 3, 10});
        System.out.println(Arrays.toString(res));
    }
}
