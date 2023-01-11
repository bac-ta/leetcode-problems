package longsest_substring_without_repeating_characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longestLength = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                j = Math.max(map.get(s.charAt(i)), j);

            longestLength = Math.max(longestLength, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        var instance = new LongestSubstringWithoutRepeatingCharacters();
        var result = instance.lengthOfLongestSubstring("hanhphuc gio gio nhu nhung chiec la vang vang vang");
        System.out.println(result);
    }
}
