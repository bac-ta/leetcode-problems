package algorthim_patterns.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalByDFS {
    public List<Integer> topologicalSort(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty())
            result.add(stack.pop()); // Revert order to get result
        return result;
    }


    private void dfs(int u, boolean[] visited, Deque<Integer> stack, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(v, visited, stack, adj);

        }
        stack.push(u);
    }
}
