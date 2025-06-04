package algorthim_patterns.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = IntStream.range(0, numCourses).mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());
        // Additionally the side b -> a (cause must learn b first then a)
        Arrays.stream(prerequisites)
                .forEach(pair -> graph.get(pair[1]).add(pair[0]));
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }


    //0: mark as not visited, 1: mark as visiting, 2: mark as visited
    private boolean hasCycle(int start, List<List<Integer>> graph, int[] visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (visited[node] == 0) {
                visited[node] = 1;

                for (int neighbor : graph.get(node)) {
                    if (visited[neighbor] == 1) return true;
                    if (visited[neighbor] == 0) stack.push(neighbor);
                }
            } else {
                visited[node] = 2;
                stack.push(node);
            }
        }
        return false;
    }

}
