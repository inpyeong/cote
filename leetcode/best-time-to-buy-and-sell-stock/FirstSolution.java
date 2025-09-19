class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length - 1; ++i) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                continue;
            }


            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[j] < answer) {
                    continue;
                }

                int profit = prices[j] - prices[i];
                if (profit > answer) {
                    answer = profit;
                }
            }
        }
        return answer;
    }
}
