package algorithm_patterns.matrixtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                bfs(grid, i, j);
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != '1') continue;

                queue.add(new int[]{newX, newY});
                grid[newX][newY] = '0';
            }
        }
    }

}
