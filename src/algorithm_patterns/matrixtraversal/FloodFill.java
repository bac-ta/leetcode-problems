package algorithm_patterns.matrixtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFillByBFS(int[][] images, int sr, int sc, int newValue) {
        if (images == null || images.length == 0) throw new RuntimeException("Images array is not valid");
        var oldValue = images[sr][sc];
        if (oldValue == newValue) return images;

        int m = images.length;
        int n = images[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] val = queue.poll();

            int r = val[0];
            int c = val[1];

            if (r < 0 || r >= m || c < 0 || c >= n || images[r][c] != newValue) continue;

            queue.offer(new int[]{r, c});

            for (int[] d : directions) {
                queue.offer(new int[]{r + d[0], c + d[1]});
            }
        }
        return images;
    }
}
