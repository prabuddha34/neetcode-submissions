public class Solution {
    private int[] dp;
    private int n;

    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int result = dfs(0, stoneValue);
        if (result == 0) return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

    private int dfs(int i, int[] stoneValue) {
        if (i >= n) return 0;
        if (dp[i] != Integer.MIN_VALUE) return dp[i];

        int res = Integer.MIN_VALUE, total = 0;
        for (int j = i; j < Math.min(i + 3, n); j++) {
            total += stoneValue[j];
            res = Math.max(res, total - dfs(j + 1, stoneValue));
        }

        dp[i] = res;
        return res;
    }
}