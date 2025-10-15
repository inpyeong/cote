class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int k = 1;

        for (int i = 0; i < n - 2 * k; ++i) {
            int cand = k;
            int a = i;

            while (a + 2 * cand - 1 < n) {
                int b = a + cand;
                if (isStricklyIncreasing(nums, a, b, cand)) {
                    k = Math.max(k, cand);
                }
                cand++;
            }
        }
        return k;
    }

    private boolean isStricklyIncreasing(
        List<Integer> nums, int a, int b, int gap
    ) {
        if (nums.size() == 2) {
            return true;
        } else {
            for (int i = 0; i < gap - 1; ++i) {
                if (nums.get(a + i) >= nums.get(a + i + 1)) {
                    return false;
                }
                if (nums.get(b + i) >= nums.get(b + i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
