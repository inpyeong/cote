class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }
        List<Integer> uniqueDamages = new ArrayList<>(freq.keySet());
        Collections.sort(uniqueDamages);

        int m = uniqueDamages.size();
        if (m == 0) return 0;

        long[] dp = new long[m];
        // dp[i] = maximum damage we can get considering unique damages [0...i]

        dp[0] = (long) uniqueDamages.get(0) * freq.get(uniqueDamages.get(0));
        for (int i = 1; i < m; ++i) {
            int curr = uniqueDamages.get(i);
            long takeCurr = (long) curr * freq.get(curr);
            long skipCurr = dp[i - 1];

            int j = findLastSafeIndex(uniqueDamages, i, curr - 2);

            if (j >= 0) {
                takeCurr += dp[j];
            }
            dp[i] = Math.max(takeCurr, skipCurr);
        }

        return dp[m - 1];
    }

    // uniqueDamages[j] < target을 만족하는 가장 큰 j 찾기
    private int findLastSafeIndex(List<Integer> arr, int end, int target) {
        int left = 0, right = end - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
