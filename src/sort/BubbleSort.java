package sort;

public class BubbleSort {
    public void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 2, 8, -7, 100, 0};
        new BubbleSort().bubbleSort(arr);
        for (Integer el : arr) {
            System.out.println(el);
        }
    }

}
