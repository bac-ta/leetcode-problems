package codility.lesson2.arrays.cyclic.rotation;

import java.util.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int length = A.length;
        if (length == 0) return A;

        K = K % length;
        if (K == 0) return A;

        int[] rotated = new int[length];

        for (int i = 0; i < length; i++) {
            rotated[(i + K) % length] = A[i]; // formula: the index's value when rotated K times is: (i+K) % length
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 3;
        int[] rotated = new CyclicRotation().solution(A, K);
        System.out.println(Arrays.toString(rotated));
    }
    /*
     * Solution:
     * First: We hande edge cases: if the array is empty or K =0, we simply return the original array.
     * Because rotating the array N times (where N is the length) brings it back to the starting posituiion,
     * we optimize K by taking K module N
     *
     * then, we create a new result array and for each index i, I place A[i] position (i + K) % N in the new array.
     * big O = O(N) (time and space)
     * */

}
