public class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        for (int i = 0; i < n - 1; i++) {
            res = (res + 1) | x;
        }
        return res;
    }
}