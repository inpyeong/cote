class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (leftSum * 2 == total) {
                    ans += 2;
                } else if (Math.abs(leftSum * 2 - total) == 1) {
                    ans += 1;
                }
            }
            leftSum += nums[i];
        }
        return ans;
    }
}

