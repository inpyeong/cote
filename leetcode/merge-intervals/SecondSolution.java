class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> merged = new ArrayList<>();
        int s = -1, e = -1;
        for (int i = 0; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (s == -1 && e == -1) {
                s = start;
                e = end;
            } else {
                if (e >= start) {
                    if (e < end) {
                        e = end;
                    }
                } else {
                    merged.add(Arrays.asList(s, e));
                    s = start;
                    e = end;
                }
            }
            if (i == intervals.length - 1) {
                merged.add(Arrays.asList(s, e));
            }
        }

        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); ++i) {
            ans[i][0] = merged.get(i).get(0);
            ans[i][1] = merged.get(i).get(1);
        }

        return ans;
    }
}
