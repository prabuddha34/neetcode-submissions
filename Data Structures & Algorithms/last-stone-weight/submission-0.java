public class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        while (n > 1) {
            int cur = stones[n - 1] - stones[n - 2];
            n -= 2;
            if (cur > 0) {
                int l = 0, r = n;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (stones[mid] < cur) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                int pos = l;
                n++;
                stones = Arrays.copyOf(stones, n);
                for (int i = n - 1; i > pos; i--) {
                    stones[i] = stones[i - 1];
                }
                stones[pos] = cur;
            }
        }
        return n > 0 ? stones[0] : 0;
    }
}