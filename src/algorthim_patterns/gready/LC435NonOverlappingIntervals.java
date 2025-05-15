package algorthim_patterns.gready;

import java.util.Arrays;
import java.util.Comparator;

public class LC435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) continue;

            count++;
            prevEnd = intervals[i][1];
        }
        return intervals.length - count;
    }

}
