package search_insert_position;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            //binary search
            int M = (L + R) / 2;
            if (A[M] < target) {
                L = M + 1;//Move right;
            } else {
                R = M;
            }
        }
        return (A[L] < target) ? L + 1 : L;
    }
}
