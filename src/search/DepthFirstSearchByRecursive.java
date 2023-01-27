package search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearchByRecursive {
    private int numsV; //Number of vertices
    private List<Integer> adjacencyList[];

    public DepthFirstSearchByRecursive(int v) {
        numsV = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencyList[v].add(w); // Add w to v's list.

    }

    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adjacencyList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[numsV];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    // Driver's Code
    public static void main(String args[]) {
        DepthFirstSearchByRecursive g = new DepthFirstSearchByRecursive(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(2);
    }


}
