class Solution {
    public int[] replaceElements(int[] arr) {
        //reverse the array i mean start from the enon-sealed
        //newMax will be calculated that will be calculated from the oldmax and the arr[i]

        int rightMax=-1;
        int newMax=0;
        for(int i=arr.length-1;i>=0;i--){
            newMax=Math.max(rightMax,arr[i]);
            arr[i]=rightMax;
            rightMax=newMax;

        }
        return arr;
        
    }
}//let the last value be -1