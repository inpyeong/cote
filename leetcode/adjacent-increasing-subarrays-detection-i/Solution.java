class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (nums.size() == 2) {
            return true;
        }
        for (int i = 0; i + 2 * k <= n; ++i) {
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int j = i; j < i + k; ++j) {
                first.add(nums.get(j));
            }
            for (int j = i + k; j < i + 2 * k; ++j) {
                second.add(nums.get(j));
            }

            // Check increasing strictly
            boolean flag = true;
            for (int j = 0; j + 1 < first.size(); ++j) {
                if (first.get(j) >= first.get(j + 1)) {
                    flag = false;
                    break;
                }
            }
            for (int j = 0; j + 1 < second.size(); ++j) {
                if (second.get(j) >= second.get(j + 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}
