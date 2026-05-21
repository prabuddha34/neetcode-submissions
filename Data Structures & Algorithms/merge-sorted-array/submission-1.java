public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int idx = 0, i = 0, j = 0;

        while (idx < m + n) {
            if (j >= n || (i < m && nums1Copy[i] <= nums2[j])) {
                nums1[idx++] = nums1Copy[i++];
            } else {
                nums1[idx++] = nums2[j++];
            }
        }
    }
}