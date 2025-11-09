class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            int val = Math.abs(nums[i]); 
            if (val <= 0 || val > n) {
                continue;
            }

            int markedIndex = val - 1;
            nums[markedIndex] = -Math.abs(nums[markedIndex]);
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) { 
                return i + 1;
            }
        }
        return n + 1;
    }
}
