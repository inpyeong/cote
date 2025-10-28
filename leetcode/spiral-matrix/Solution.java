class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int y = 0, x = 0, d = 0;
        while (true) {
            boolean done = true;
            visited[y][x] = true;
            ans.add(matrix[y][x]);

            for (int i = 0; i < dirs.length; ++i) {
                int ny = y + dirs[d][0];
                int nx = x + dirs[d][1];

                if (blocked(visited, ny, nx, m, n)) {
                    d++;
                    d %= dirs.length;
                } else {
                    y = ny;
                    x = nx;
                    done = false;
                    break;
                }
            }
            if (done) {
                break;
            }
        }
        return ans;
    }

    private boolean blocked(boolean[][] visited, int ny, int nx, int m, int n) {
        if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
            return true;
        }
        if (visited[ny][nx]) {
            return true;
        }
        return false;
    }
}
