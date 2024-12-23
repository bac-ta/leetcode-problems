package search_insert_position;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            //binary search
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;//Move right;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var search = new SearchInsertPosition().searchInsert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 14}, 10);
        System.out.println(search);
    }
}
