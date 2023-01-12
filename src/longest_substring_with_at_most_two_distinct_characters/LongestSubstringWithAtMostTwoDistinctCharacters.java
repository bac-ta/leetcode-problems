package longest_substring_with_at_most_two_distinct_characters;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] track = new int[256];
        int startIndex = 0, numDistinct = 0, maxLen = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            if (track[s.charAt(endIndex)] == 0) {
                // Not exist
                numDistinct++;
            }
            track[s.charAt(endIndex)]++;
            while (numDistinct > 2) {
                track[s.charAt(startIndex)]--;
                if (track[s.charAt(startIndex)] == 0)
                    numDistinct--;
                startIndex++;
            }
            System.out.println("start index: " + startIndex);
            System.out.println("end index: " + endIndex);
            maxLen = Math.max(endIndex - startIndex + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var maxLength = new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eeeeceba");
        System.out.println(maxLength);
    }
}
