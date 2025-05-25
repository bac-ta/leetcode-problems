package algorthim_patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharacterReplacement {
    public int findLongestRepeatingChar(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxFreq = 0, maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            var chRight = str.charAt(right);
            map.put(chRight, map.getOrDefault(chRight, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(chRight));

            while (right - left + 1 - maxFreq > k) {
                var chLeft = str.charAt(left);
                map.put(chLeft, map.get(chLeft) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;
    }
}
