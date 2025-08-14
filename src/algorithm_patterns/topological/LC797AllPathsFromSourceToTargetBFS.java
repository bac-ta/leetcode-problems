package algorithm_patterns.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC797AllPathsFromSourceToTargetBFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int target = graph.length - 1;

        //The queue save all the current ways
        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(List.of(0));
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.getLast();

            if (lastNode == target) res.add(path);
            else {
                for (int nextNode : graph[lastNode]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nextNode);
                    queue.offer(newPath);
                }
            }
        }
        return res;
    }
}
