

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> curr, int total, int target) {

        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (total > target) {
            return;
        }

        for (int j = i; j < nums.length; j++) {

            if (total + nums[j] > target) {
                break; // pruning works because array is sorted
            }

            curr.add(nums[j]);
            dfs(j, nums, curr, total + nums[j], target);
            curr.remove(curr.size() - 1);
        }
    }
}
