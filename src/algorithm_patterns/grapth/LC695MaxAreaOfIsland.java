package algorithm_patterns.grapth;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC695MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = findMaxAreaOfIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int findMaxAreaOfIsland(int[][] grid, int row, int col) {
        Deque<int[]> queue = new ArrayDeque<>();
        grid[row][col] = 0; // visited
        queue.offer(new int[]{row, col});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int m = grid.length;
        int n = grid[0].length;

        int area = 0;

        while (!queue.isEmpty()) {
            area++;
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] d : directions) {
                int newRow = x + d[0];
                int newCol = y + d[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0; //mark visited
                }
            }
        }
        return area;
    }
}
