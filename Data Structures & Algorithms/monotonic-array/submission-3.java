class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean checkIncreasing = true;

        // Check increasing
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                checkIncreasing = false;
            }
        }

        boolean checkDecreasing = true;

        // Check decreasing
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                checkDecreasing = false;
            }
        }

        return checkIncreasing || checkDecreasing;
    }
}