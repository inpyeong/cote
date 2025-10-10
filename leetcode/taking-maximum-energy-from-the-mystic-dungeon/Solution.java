class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; --i) {
            if (i + k >= n) {
                dp[i] = energy[i];
            } else {
                dp[i] = dp[i + k] + energy[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
