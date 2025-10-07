class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; ++i) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; ++j) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int totalWater = 0;

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            for (int i = 0; i < dirs.length; ++i) {
                int ny = curr.y + dirs[i][0];
                int nx = curr.x + dirs[i][1];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;

                int neighborHeight = heightMap[ny][nx];
                int trapped = Math.max(0, curr.height - neighborHeight);
                totalWater += trapped;

                pq.offer(new Cell(ny, nx, Math.max(curr.height, neighborHeight)));
            }
        }

        return totalWater;
    }

    static class Cell {
        int y, x, height;
        Cell(int y, int x, int height) {
            this.y = y;
            this.x = x;
            this.height = height;
        }
    }
}
