class Solution {
    public int jump(int[] nums) {
        int l=0,r=0;
        int res=0;
        int farthest=0;
        while(r<nums.length-1){
            farthest=0;
            for(int i=l;i<r+1;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            l++;
            r=farthest;
            res++;
        }
        return res;
    }
}
