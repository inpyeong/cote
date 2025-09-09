class Solution {

    static int M;
    static int N;
    static int[][] DIRS = {{1, 0}, {0, 1}};

    public int minPathSum(int[][] grid) {

        // Initiate variables
        M = grid.length;
        N = grid[0].length;
        int[][] costs = new int[M][N];
        initCosts(costs);

        // Set cost for start point
        costs[0][0] = grid[0][0];

        // Do dynamic programming
        for (int y = 0; y < M; ++y) {
            for (int x = 0; x < N; ++x) {
                int c = costs[y][x];
                
                for (int d = 0; d < DIRS.length; ++d) {
                    int ny = y + DIRS[d][0]; 
                    int nx = x + DIRS[d][1]; 

                    if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                        continue;
                    }

                    int nc = costs[y][x] + grid[ny][nx];
                    if (costs[ny][nx] > nc) {
                        costs[ny][nx] = nc;
                    }
                }
            }
        }

        return costs[M-1][N-1];
    }

    void initCosts(int[][] costs) {
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
