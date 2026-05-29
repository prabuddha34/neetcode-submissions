class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0;
        int tens=0;
        for(int num:bills){
            if(num ==5){
                fives++;
            }
            else if(num ==10){
                fives--;
                tens++;
            }
            else if(tens>0){
                fives--;
                tens--;
            }
            else{
              fives -= 3;
            }
            if(fives<0){
                return false;
            }
        }
        return true;
    }
}