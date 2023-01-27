package search;

public class BinarySearch {
    public int binarySearch(int[] sortedArray, int key) {
        int left = 0;
        int right = sortedArray.length - 1;

        for (int i = 0; i < sortedArray.length - 1; i++) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == key) {
                return mid;
            } else if (sortedArray[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 9, 10};
        var key = 9;
        var result = new BinarySearch().binarySearch(arr, key);
        System.out.println(result);
    }
}
