public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        return dfs(0, s, words, dp);
    }

    private int dfs(int i, String s, Set<String> words, int[] dp) {
        if (dp[i] != -1) return dp[i];
        int res = 1 + dfs(i + 1, s, words, dp);
        for (int j = i; j < s.length(); j++) {
            if (words.contains(s.substring(i, j + 1))) {
                res = Math.min(res, dfs(j + 1, s, words, dp));
            }
        }
        dp[i] = res;
        return res;
    }
}