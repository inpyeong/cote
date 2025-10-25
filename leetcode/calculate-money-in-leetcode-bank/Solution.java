class Solution {
    public int totalMoney(int n) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int quotient = i / 7;
            int remainder = i % 7;

            result += (quotient + 1) + remainder;
        }
        return result;
    }
}
