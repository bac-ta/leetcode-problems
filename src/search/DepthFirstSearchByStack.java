package search;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class DepthFirstSearchByStack {
    int V;                                          //number of nodes

    List<Integer>[] adj;                      //adjacency list

    DepthFirstSearchByStack(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();

    }

    void addEdge(int v, int w) {
        adj[v].add(w);                              //adding an edge to the adjacency list (edges are bidirectional in this example)
    }

    void DFS(int n) {
        boolean isVisited[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(n);                                    //push root node to the stack
        int a = 0;

        while (!stack.empty()) {
            n = stack.peek();                       //extract the top element of the stack
            stack.pop();                            //remove the top element from the stack

            if (isVisited[n] == false) {
                System.out.print(n + " ");
                isVisited[n] = true;
            }

            for (int i = 0; i < adj[n].size(); i++)  //iterate through the linked list and then propagate to the next few isVisited
            {
                a = adj[n].get(i);
                if (!isVisited[a])                    //only push those isVisited to the stack which aren't in it already
                {
                    stack.push(a);                          //push the top element to the stack
                }
            }

        }
    }

    public static void main(String[] args) {
        DepthFirstSearchByStack g = new DepthFirstSearchByStack(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }
}