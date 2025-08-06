package algorithm_patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesAnagram {
    public int doCount(String text, String pattern) {
        if (text == null || text.isBlank() || pattern == null || pattern.isBlank() || text.length() < pattern.length())
            return -1;

        Map<Character, Long> textCountMap = new HashMap<>();
        Map<Character, Long> patternCountMap = new HashMap<>();

        for (Character c : pattern.toCharArray()) {
            patternCountMap.put(c, patternCountMap.getOrDefault(c, 0L) + 1);
        }

        int textLength = text.length();
        int patternLength = pattern.length();

        int count = 0;

        for (int i = 0; i < textLength; i++) {
            textCountMap.put(text.charAt(i), textCountMap.getOrDefault(text.charAt(i), 0L) + 1);

            if (i + 1 < patternLength) continue;

            if (textCountMap.equals(patternCountMap)) count++;

            // Remove first element of window when move to right
            char firstOfWindow = text.charAt(i - patternLength + 1);

            // Decrement occurrences
            textCountMap.put(firstOfWindow, textCountMap.get(firstOfWindow) - 1);
            if (textCountMap.get(firstOfWindow) == 0) {
                textCountMap.remove(firstOfWindow);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String text = "gotxxotgxdogt";
        String pattern ="got";

        int count =  new CountOccurrencesAnagram().doCount(text, pattern);
        System.out.printf("count anagram: "+ count);
    }



}