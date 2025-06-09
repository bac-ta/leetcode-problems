package algorthim_patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC3LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            var chRight = s.charAt(right);
            if (map.containsKey(chRight) && map.get(chRight) >= left) {
                left = map.get(chRight) + 1;
            }
            map.put(chRight, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public String longestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;     // Điểm bắt đầu chuỗi dài nhất
        int left = 0;      // Con trỏ trái của cửa sổ

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Nếu đã gặp và nằm trong cửa sổ hiện tại
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);

            // Cập nhật độ dài tối đa và vị trí bắt đầu
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxLength);
    }

}
