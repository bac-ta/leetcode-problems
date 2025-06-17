package algorthim_patterns.grapth;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC994RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offerLast(new int[]{i, j});
                }
            }
        }
        // If no fresh oranges, return 0
        if (freshOranges == 0) return 0;

        // Step 2: Run BFS starting with all rotten oranges
        return getMinutes(grid, queue, freshOranges);
    }

    private int getMinutes(int[][] grid, Deque<int[]> queue, int freshOranges) {
        int minutes = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 2) {
                        grid[newRow][newCol] = 1;
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? -1 : minutes - 1;
    }
}
