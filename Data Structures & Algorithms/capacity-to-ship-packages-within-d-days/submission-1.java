class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;

        //search the range 

          for (int w : weights) {

            left = Math.max(left, w);

            right += w;
        }
         while (left < right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {

                right = mid;
            }
            else {

                left = mid + 1;
            }
        }

        return left;


    }
    public boolean canShip(int[] weights, int days, int capacity){
        int currentWeight=0;

         int requiredDays = 1;
        
        for(int w:weights){
            if(currentWeight+w>capacity){
                  requiredDays++;

                currentWeight = 0;
            }
                   currentWeight += w;

        }

        return requiredDays <= days;

    }
}