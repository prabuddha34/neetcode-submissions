class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestLength = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Consecutive sequence
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                count = 1;
            }

            longestLength = Math.max(longestLength, count);
        }

        return longestLength;
    }
}
