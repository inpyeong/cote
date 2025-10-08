import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int le = 0, ri = m - 1;
            while (le <= ri) {
                int mid = (le + ri) / 2;
                if ((long) potions[mid] * spells[i] >= success) {
                    ri = mid - 1;
                } else {
                    le = mid + 1;
                }
            }
            ans[i] = m - le;
        }
        
        return ans;
    }
}
