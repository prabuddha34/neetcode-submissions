public class Solution {
    private int[][] dp;

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n][k + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return dfs(nums, 0, k, n);
    }

    private int dfs(int[] nums, int i, int m, int n) {
        if (i == n) {
            return m == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (m == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][m] != -1) {
            return dp[i][m];
        }

        int res = Integer.MAX_VALUE;
        int curSum = 0;
        for (int j = i; j <= n - m; j++) {
            curSum += nums[j];
            res = Math.min(res, Math.max(curSum, dfs(nums, j + 1, m - 1, n)));
        }

        return dp[i][m] = res;
    }
}