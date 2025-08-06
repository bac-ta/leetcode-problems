package algorithm_patterns.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalByBFS {
    public List<Integer> topologicalSort(int n, List<List<Integer>> adj) {
        // init the degrees into for each vertex
        int[] inDegrees = new int[n];

        for (List<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegrees[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i); // add vertex has in-degree=0 to last position
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : adj.get(u)) {
                if (--inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (result.size() != n)
            throw new RuntimeException("Graph has a cycle!");

        return result;

    }
}
