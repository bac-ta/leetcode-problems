package algorthim_patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC76MinimumWindowSubstring {
    int left = 0;
    int min = Integer.MAX_VALUE;
    int startIndex = 0;
    int have = 0;

    public String minWindow(String s, String t) {
        if (s == null) throw new RuntimeException("s must be not null");
        if (t == null || t.isBlank()) return s;
        if (s.isBlank()) return "";

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (var ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            var chRight = s.charAt(right);
            sMap.put(chRight, sMap.getOrDefault(chRight, 0) + 1);
            if (tMap.containsKey(chRight) && Objects.equals(tMap.get(chRight), sMap.get(chRight))) have++;

            while (have == tMap.size()) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    startIndex = left;
                }

                // Decrease occurrences of sMap
                var chLeft = s.charAt(left);
                sMap.put(chLeft, sMap.get(chLeft) - 1);

                if (tMap.containsKey(chLeft) && sMap.get(chLeft) < tMap.get(chLeft))
                    have--;

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + min);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        var output = new LC76MinimumWindowSubstring().minWindow(s, t);
        System.out.printf("Output: " + output);
    }
}