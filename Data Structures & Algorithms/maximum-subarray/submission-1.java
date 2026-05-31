class Solution {
    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int maxTill = nums[0];

        for (int i = 1; i < nums.length; i++) {

            current = Math.max(nums[i], current + nums[i]);
            maxTill = Math.max(maxTill, current);
        }

        return maxTill;
    }
}