class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
          for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // infinity
        }
        for(int i=1;i<=amount;i++){
for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i],
                                     1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
 