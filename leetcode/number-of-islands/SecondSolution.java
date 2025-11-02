class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    continue;
                }
                if (visited[i][j]) {
                    continue;
                }

                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int y = curr[0];
                    int x = curr[1];

                    for (int d = 0; d < dirs.length; ++d) {
                        int ny = y + dirs[d][0];
                        int nx = x + dirs[d][1];

                        if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                            continue;
                        }

                        if (!visited[ny][nx] && grid[ny][nx] == '1') {
                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}
