class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;

        int ans[]=new int[n];
      Stack<Integer>stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            //Trying to take the colder temps for me 

            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                int getNextWarmIndex=stack.peek();
                ans[i]=getNextWarmIndex-i;
            }
            stack.push(i);
        }
        return ans;
    }
}
