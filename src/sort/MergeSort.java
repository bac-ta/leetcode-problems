package sort;

public class MergeSort {
    public void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        //Fill left array
        System.arraycopy(arr, 0, leftArr, 0, mid);
        //Fill right array
        if (n - mid >= 0) System.arraycopy(arr, mid, rightArr, 0, n - mid);

        mergeSort(leftArr, mid);
        mergeSort(rightArr, n - mid);
        merge(arr, leftArr, rightArr, mid, n - mid);
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i] > rightArr[j]) {
                arr[k++] = rightArr[j++];
            } else {
                arr[k++] = leftArr[i++];
            }
        }
        while (i < left)
            arr[k++] = leftArr[i++];
        while (j < right)
            arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 3, 4, 100, -12, -3};
        new MergeSort().mergeSort(arr, arr.length);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
