public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n + 1][n + 1];
        return dfs(0, 0, s, memo);
    }

    private boolean dfs(int i, int open, String s, Boolean[][] memo) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (memo[i][open] != null) return memo[i][open];

        boolean result;
        if (s.charAt(i) == '(') {
            result = dfs(i + 1, open + 1, s, memo);
        } else if (s.charAt(i) == ')') {
            result = dfs(i + 1, open - 1, s, memo);
        } else {
            result = (dfs(i + 1, open, s, memo) ||
                      dfs(i + 1, open + 1, s, memo) ||
                      dfs(i + 1, open - 1, s, memo));
        }

        memo[i][open] = result;
        return result;
    }
}