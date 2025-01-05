package rotate_array;

public class RotateArray {
    public void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int length = arr.length;
        int t = length - (k % length);
        reverse(arr, 0, t - 1);
        reverse(arr, t, length - 1);
        reverse(arr, 0, length - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        if (arr.length == 1)
            return;

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
