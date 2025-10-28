class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for (String row : bank) {
            int curr = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    curr++;
                }
            }

            if (curr > 0) {
                ans += prev * curr;
                prev = curr;
            }
        }
        return ans;
    }
}
