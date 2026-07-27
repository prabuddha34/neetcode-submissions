public class Solution {
    public int integerBreak(int n) {
        return dfs(n, n - 1);
    }

    private int dfs(int num, int i) {
        if (Math.min(num, i) == 0) {
            return 1;
        }

        if (i > num) {
            return dfs(num, num);
        }

        return Math.max(i * dfs(num - i, i), dfs(num, i - 1));
    }
}
        