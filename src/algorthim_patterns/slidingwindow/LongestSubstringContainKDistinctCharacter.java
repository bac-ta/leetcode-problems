package algorthim_patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringContainKDistinctCharacter {
    public String getLongest(String s, int k) {
        if (k <= 0) throw new RuntimeException("k must a positive integer number");
        if (s.length() < k) throw new RuntimeException("k value is out of bound length of characters");

        int left = 0, maxLength = 0, startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char rightCharacter = s.charAt(right);
            map.put(rightCharacter, map.getOrDefault(rightCharacter, 0) + 1);

            while (map.size() > k) {
                char leftCharacter = s.charAt(left);
                map.put(leftCharacter, map.get(leftCharacter) - 1);

                if (map.get(leftCharacter) == 0) map.remove(leftCharacter);
                left++;
            }
            if (map.size() == k && right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        String s = "abcbdbdbbdcdabd";
        int k = 3;
        System.out.println("Longest substring with " + k + " distinct characters: " + new LongestSubstringContainKDistinctCharacter().getLongest(s, k));
    }
}
