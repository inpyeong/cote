import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>(); // lake -> last rainy day index
        TreeSet<Integer> dryDays = new TreeSet<>();   // available dry days (indexes)

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // default (will be overwritten if used)
            } else {
                int lake = rains[i];
                ans[i] = -1; // raining day
                
                if (full.containsKey(lake)) {
                    // Find the dry day after the last time this lake was filled
                    Integer dryDay = dryDays.higher(full.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // impossible to prevent flood
                    }
                    ans[dryDay] = lake; // dry this lake on that dry day
                    dryDays.remove(dryDay);
                }
                full.put(lake, i);
            }
        }
        return ans;
    }
}

