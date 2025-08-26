import java.util.*;

class Solution {
    private static class Point {
        final int row;
        final int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(new Point(i, j), grid, visited);
                    result++;
                }
            }
        }

        return result;
    }

    private void bfs(Point start, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.row][start.col] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int[] dir : DIRECTIONS) {
                int nr = curr.row + dir[0];
                int nc = curr.col + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    !visited[nr][nc] && grid[nr][nc] == '1') {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}

