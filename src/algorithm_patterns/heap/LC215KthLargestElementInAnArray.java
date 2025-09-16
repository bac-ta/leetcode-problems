package algorithm_patterns.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
