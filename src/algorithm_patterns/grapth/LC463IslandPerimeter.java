package algorithm_patterns.grapth;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    return findPerimeter(grid, queue, visited);
                }
            }
        }
        return 0;
    }

    private int findPerimeter(int[][] grid, Deque<int[]> deque, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int row = cell[0];
            int col = cell[1];
            for (int[] d : directions) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 0) perimeter++;

                else if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    deque.offer(new int[]{newRow, newCol});
                }
            }

        }
        return perimeter;
    }
}
