class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;   // buy day
        int right = 1;  // sell day

        int maxProfit = 0;

        while (right < prices.length) {

            // profitable
            if (prices[right] > prices[left]) {

                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);

            } else {
                // found smaller buying price
                left = right;
            }

            right++;
        }

        return maxProfit;
    }
}