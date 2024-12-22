package rotate_array;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] arr, int k) {
        int length = arr.length;
        System.out.println("length: " + length);
        int t = length - (k % length);
        System.out.println("t: " + t);
        reverse(arr, 0, t - 1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, t, length - 1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void reverse(int[] arr, int left, int right) {
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new RotateArray().rotate(arr, 4);
    }
}
