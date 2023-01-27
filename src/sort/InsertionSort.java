package sort;

public class InsertionSort {
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 2, 3, 4, 5, 1, -2, 100};
        new InsertionSort().insertionSort(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
