package move_zeroes;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] arr) {
        int firstZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            swap(firstZero, i, arr);
            firstZero++;
        }
    }

    private void swap(int index1, int index2, int[] arr) {
        int val2 = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = val2;
    }

    public static void main(String[] args) {
        int[] arr = {3, 12, 0, 1, 2, 0, 0, 9};
        new MoveZeroes().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
