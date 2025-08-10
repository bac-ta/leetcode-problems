package algorithm_patterns.grapth;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC994RottingOranges2 {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int minutes = 0;
        int freshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    stack.offer(new int[]{i, j});
                }
            }
        }

        if (freshOranges == 0) return 0;

        return findMinutes(grid, stack, freshOranges);

    }

    private int findMinutes(int[][] grid, Deque<int[]> stack, int freshOranges) {
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        while (!stack.isEmpty()) {
            for (int i = 0; i < stack.size(); i++) {
                int[] curr = stack.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        stack.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes - 1 : -1;
    }
}
