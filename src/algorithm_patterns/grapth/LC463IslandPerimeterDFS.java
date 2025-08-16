package algorithm_patterns.grapth;

public class LC463IslandPerimeterDFS {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return findPerimeter(grid, i, j, visited);
                }
            }
        }
        return 0;
    }

    private int findPerimeter(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || visited[row][col]) return 0;

        int perimeter = 0;
        visited[row][col] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            perimeter += findPerimeter(grid, newRow, newCol, visited);
        }
        return perimeter;
    }
}
