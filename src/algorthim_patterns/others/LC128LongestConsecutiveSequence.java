package algorthim_patterns.others;

import java.util.HashSet;
import java.util.Set;

public class LC128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int curentNum = num;
            int curentStreak = 1;
            while (set.contains(curentNum + 1)) {
                curentStreak++;
                curentNum++;
            }
            longest = Math.max(longest, curentStreak);
        }
        return longest;
    }
}
