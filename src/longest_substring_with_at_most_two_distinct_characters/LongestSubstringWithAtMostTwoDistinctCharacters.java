package longest_substring_with_at_most_two_distinct_characters;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] track = new int[256];
        int i = 0, numDistinct = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (track[s.charAt(j)] == 0) {
                // Not exist
                numDistinct++;
            }
            track[s.charAt(j)]++;
            while (numDistinct > 2) {
                track[s.charAt(i)]--;
                if (track[s.charAt(i)] == 0)
                    numDistinct--;
                i++;
            }
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var maxLength = new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eeeeceba");
        System.out.println(maxLength);
    }
}
