class Solution {
    public int[][] merge(int[][] intervals) {
        sortIntervals(intervals);
        printIntervals(intervals);

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        List<Integer> interval = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            if (interval.isEmpty()) {
                interval.add(start);
                interval.add(end);
            }

            if (interval.get(1) >= start && interval.get(1) <= end) {
                interval.remove(interval.size() - 1);
                interval.add(end);
            }

            if (interval.get(1) < start) {

                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(interval);
                mergedIntervals.add(tmp);

                interval.clear();
                interval.add(start);
                interval.add(end);
            }

            if (i == intervals.length - 1 && !interval.isEmpty()) {
                mergedIntervals.add(interval);
            }
        }

        System.out.println(mergedIntervals);

        int[][] answer = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); ++i) {
            answer[i][0] = mergedIntervals.get(i).get(0);
            answer[i][1] = mergedIntervals.get(i).get(1);
        }

        return answer;
    }

    void sortIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return 0;
                }
                return a[1] < b[1] ? -1 : 1;
            }
            return a[0] < b[0] ? -1 : 1;
        });
    }

    void printIntervals(int[][] intervals) {

        for (int i = 0; i < intervals.length; ++i) {
            for (int j = 0; j < 2; ++j) {
                System.out.print(intervals[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
