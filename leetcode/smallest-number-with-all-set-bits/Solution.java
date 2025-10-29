class Solution {
    public int smallestNumber(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        int ans = 0;
        for (int i = 0; i < sb.toString().length(); ++i) {
            ans += Math.pow(2, i);
        }
        return ans;
        If n is already all 1s, return it directly
    }
}
