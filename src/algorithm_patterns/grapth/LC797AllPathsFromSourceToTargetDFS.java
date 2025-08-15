package algorithm_patterns.grapth;

import java.util.ArrayList;
import java.util.List;

public class LC797AllPathsFromSourceToTargetDFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // bắt đầu từ node 0
        dfs(0, graph, path, res);
        return res;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        int target = graph.length - 1;
        if (node == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(nextNode, graph, path, res);
            path.removeLast(); //backtrack
        }
    }
}
