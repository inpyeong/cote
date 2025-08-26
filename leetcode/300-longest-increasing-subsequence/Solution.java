class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[][] increasing = new int[3000][3000];

        for (int i = 0; i < nums.length; ++i) {
            increasing[i][i] = 1;

            for (int j = i + 1; j < nums.length; ++j) {
                
                if (nums[i] == nums[j]) {
                    increasing[i][j] = 1;
                } else if (nums[i] > nums[j]) {
                    increasing[i][j] = 0;
                } else {
                    increasing[i][j] = increasing[i][i] + 1;
                    for (int k = j - 1; k >= i; --k) {
                        if (nums[k] < nums[j] && increasing[i][j] <= increasing[i][k]) {
                            increasing[i][j] = increasing[i][k] + 1;
                        }
                    }
                }

                if (result < increasing[i][j]) {
                    result = increasing[i][j];
                }
            }
        }

        return result;
    }
}
