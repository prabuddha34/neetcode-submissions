class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int res=Integer.MAX_VALUE;
        int total=0;
        for(int right=0;right<nums.length;right++){
             total=total+nums[right];
             while(total>=target){
                res=Math.min(right-left+1,res);
                total-=nums[left];
                left++;
             }
        }
        return res ==Integer.MAX_VALUE?0:res;
    }
}