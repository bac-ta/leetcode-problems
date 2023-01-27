package search;

import java.util.Arrays;

public class ExponentialSearch {
    public int exponentialSearch(int arr[], int n, int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i * 2;
        return Arrays.binarySearch(arr, i / 2,
                Math.min(i, n - 1), x);
    }
}
