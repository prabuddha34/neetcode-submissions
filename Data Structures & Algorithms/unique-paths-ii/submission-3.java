class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[M - 1][N - 1] == 1)
            return 0;

        int[][] dp = new int[M][N];
        dp[M - 1][N - 1] = 1;

        for (int r = M - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {

                if (r == M - 1 && c == N - 1)
                    continue;

                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    if (r + 1 < M)
                        dp[r][c] += dp[r + 1][c];

                    if (c + 1 < N)
                        dp[r][c] += dp[r][c + 1];
                }
            }
        }

        return dp[0][0];
    }
}