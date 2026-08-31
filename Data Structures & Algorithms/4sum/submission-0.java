public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int k = j + 1; k < nums.length; k++) {
                    count.put(nums[k], count.get(nums[k]) - 1);
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                    long fourth = target - (nums[i] + nums[j] + 0L + nums[k]);
                    if (fourth > Integer.MAX_VALUE || fourth < Integer.MIN_VALUE) {
                        continue;
                    }
                    if (count.getOrDefault((int) fourth, 0) > 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], (int) fourth));
                    }
                }

                for (int k = j + 1; k < nums.length; k++) {
                    count.put(nums[k], count.get(nums[k]) + 1);
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }

        return res;
    }
}