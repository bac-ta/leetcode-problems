package longsest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longestLength = 0;

        for (int endIndex = 0, startIndex = 0; endIndex < s.length(); endIndex++) {
            if (map.containsKey(s.charAt(endIndex)))
                startIndex = Math.max(map.get(s.charAt(endIndex)), startIndex);

            longestLength = Math.max(longestLength, endIndex - startIndex + 1);
            map.put(s.charAt(endIndex), endIndex + 1);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        var instance = new LongestSubstringWithoutRepeatingCharacters();
        var result = instance.lengthOfLongestSubstring("hanhphuc gio gio nhu nhung chiec la vang vang vang");
        System.out.println(result);
    }
}
