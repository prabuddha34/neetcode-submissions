public class Solution {
    private Map<Integer, Integer> memo;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int total) {
        if (memo.containsKey(total)) {
            return memo.get(total);
        }

        int res = 0;
        for (int num : nums) {
            if (total < num) {
                break;
            }
            res += dfs(nums, total - num);
        }
        memo.put(total, res);
        return res;
    }
}