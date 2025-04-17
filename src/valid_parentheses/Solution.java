package valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null) throw new RuntimeException();
        if (s1 == null || s1.isEmpty()) return true;
        if (s1.equals(s2)) return true;
        if (s2.isBlank() || s2.length() < s1.length()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        String s1Temp = s1;

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if (s1Temp.contains(String.valueOf(c))) {
                stack.push(c);
                s1Temp = s1Temp.replace(String.valueOf(c), "");

                System.out.println("s1Temp: " + s1Temp);
                if (s2.isBlank() || s2.length() < s1.length()) {
                    return false;
                }
                if (stack.size() == s1.length()) return true;
            } else {
                stack.clear();
                s1Temp = s1;
                s2 = s2.substring(1);

                System.out.println("s2: " + s2);
                if (s2.isBlank() || s2.length() < s1.length()) {
                    System.out.println("vao day");
                    return false;
                } else {
                    checkInclusion(s1, s2);
                    if (stack.size() == s1.length()) return true;
                }
            }

        }
        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
    }
}
