package algorithm_patterns.stack_monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        int length = nums.length;
        int[] resutls = new int[length];
        Arrays.fill(resutls, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                resutls[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return resutls;
    }
}
