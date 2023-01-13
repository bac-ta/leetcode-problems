package valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> map;

    static {
        map = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        System.out.println(stack.isEmpty());
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("([()])");
    }
}
