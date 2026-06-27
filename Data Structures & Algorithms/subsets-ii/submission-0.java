public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, subset, nums);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, subset, nums);
    }
}