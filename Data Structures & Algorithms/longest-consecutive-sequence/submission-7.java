class Solution {
    public int longestConsecutive(int[] nums) {

        //This is the Base Case
        
        if(nums.length ==0){
            return 0;
        }
        int count=1;
        int  maxCount=1;
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){

            //check for the duplicates 

            if(nums[i] == nums[i-1]){
                continue;
            }
            // check for the consecutives

            if(nums[i]- nums[i-1] == 1){
              count++;
            }
            else{
                count=1;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
