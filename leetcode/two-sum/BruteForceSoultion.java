class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = null;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int twoSum = nums[i] + nums[j];
                if (twoSum == target) {
                    answer = new int[]{i, j};
                }
            }
        }
        return answer;
    }
}
