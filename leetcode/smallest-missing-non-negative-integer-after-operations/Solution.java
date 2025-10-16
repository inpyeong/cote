class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remainders = new int[1000001];
        for (int num : nums) {
            int remainder = (num % value + value) % value; 
            remainders[remainder]++;
        }

        int mex = 0;
        while (remainders[mex % value] > 0) {
            remainders[mex % value]--;
            mex++;
        }
        return mex;
    }
}
