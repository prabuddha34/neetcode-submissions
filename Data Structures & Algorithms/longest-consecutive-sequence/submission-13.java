class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxCount=1;
        int count=1;
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            //Check for the duplicates inside the array 

            if(nums[i] == nums[i-1]){continue;}

            //check for the getting a streak

           else if(nums[i]-nums[i-1] == 1){
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
