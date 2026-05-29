class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0;
        int tens=0;
        for(int b:bills){
            if(b == 5){
                fives++;
            }
            else if(b ==10){
                tens++;
                fives--;
            }
            else if(tens>0){
                fives--;
                tens--;
            }
            else {
                fives-=3;
            }
            if(fives<0){
                return false;
            }
        }
        return true;

    }
}