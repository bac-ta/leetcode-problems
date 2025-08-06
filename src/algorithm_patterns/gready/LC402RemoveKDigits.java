package algorithm_patterns.gready;

import java.util.Stack;

public class LC402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < num.length(); i++) {
            while (count < k) {
                int currentDigit = num.charAt(i) - '0';
                if (stack.isEmpty()) stack.push(currentDigit);
                else {
                    int digitInStack = stack.pop();
                    stack.push(Math.min(digitInStack, currentDigit));
                }
                count++;
            }

        }
        return stack.isEmpty() ? "0" : stack.pop() + "";
    }
}
