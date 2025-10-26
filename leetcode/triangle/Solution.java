class Solution {

    static class Position {
        int y;
        int x;
        int sum;

        Position(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); ++i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                int curr = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + curr;
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + curr;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + curr, dp[i-1][j] + curr);
                }
            }
        }
        for (int i = 0; i < dp[triangle.size() - 1].length; ++i) {
            answer = Math.min(answer, dp[triangle.size() - 1][i]);
        }
        return answer;
    }
}
