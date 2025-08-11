package algorithm_patterns.grapth;

public class LC695MaxAreaOfIslandDFS {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, findArea(grid, i, j));
                }
            }
        }
        return maxArea;

    }

    private int findArea(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }

        int area = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            area += findArea(grid, newRow, newCol);
        }
        return area;
    }
}
