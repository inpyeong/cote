class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        int start = -1, end = -1;
        for (int i = 0; i < intervals.length; ++i) {
            int[] interval = intervals[i];

            if (start == -1 && end == -1) {
                start = interval[0];
                end = interval[1];
            } else {
                if (end < interval[0]) {
                    merged.add(new int[]{start, end});
                    start = interval[0];
                    end = interval[1];
                } else if (end < interval[1]) {
                    end = interval[1];
                }
            }
        }
        merged.add(new int[]{start, end}); // Add the last unhandled element.

        int[][] answer = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); ++i) {
            answer[i][0] = merged.get(i)[0];
            answer[i][1] = merged.get(i)[1];
        }

        return answer;
    }
}
