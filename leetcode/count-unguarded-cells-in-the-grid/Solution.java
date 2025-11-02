import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n]; // 0: empty, 1: wall, 2: guard, 3: watched

        // mark walls and guards
        for (int[] w : walls) grid[w[0]][w[1]] = 1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // row-wise scan
        for (int i = 0; i < m; i++) {
            boolean watching = false;
            // left → right
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) watching = false;         // wall blocks
                else if (grid[i][j] == 2) watching = true;     // guard starts watching
                else if (watching) grid[i][j] = 3;             // watched
            }
            watching = false;
            // right → left
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) watching = false;
                else if (grid[i][j] == 2) watching = true;
                else if (watching) grid[i][j] = 3;
            }
        }

        // column-wise scan
        for (int j = 0; j < n; j++) {
            boolean watching = false;
            // top → bottom
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) watching = false;
                else if (grid[i][j] == 2) watching = true;
                else if (watching) grid[i][j] = 3;
            }
            watching = false;
            // bottom → top
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 1) watching = false;
                else if (grid[i][j] == 2) watching = true;
                else if (watching) grid[i][j] = 3;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}

