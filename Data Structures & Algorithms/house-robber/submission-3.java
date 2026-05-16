class Solution {
    public int rob(int[] nums) {
        int robber1=0;
        int robber2=0;

        for(int num:nums){
            int t=Math.max(num+robber1,robber2);
            robber1=robber2;
            robber2=t;
        }
        return robber2;
    }
}
