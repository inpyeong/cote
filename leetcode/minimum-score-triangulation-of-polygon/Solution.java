class Solution {
    static int N;

    public int minScoreTriangulation(int[] values) {
        N = values.length;

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return doDfs(values, dp, 1, N - 1);
    }

    int doDfs(int[] values, int[][] dp, int i, int j) {
        if (i >= j) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int min = Integer.MAX_VALUE;
            for (int k = i; k < j; ++k) {
                min = Math.min(
                    min,
                    doDfs(values, dp, i, k) + doDfs(values, dp, k + 1, j) + (values[i - 1] * values[k] * values[j])
                );
            }
            return dp[i][j] = min;
        }
    }
}
