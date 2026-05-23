class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n=temperatures.length;

        int ans[]=new int[n];

        Stack<Integer>stack=new Stack<>();
        
        for(int i=n-1;i>=0;i--){

               while (stack.size() > 0 &&
                   temperatures[stack.peek()] <= temperatures[i]) {

                stack.pop();
            }
  
 
            if(!stack.isEmpty()){
                int nextWarmIndex=stack.peek();

               ans[i]=nextWarmIndex-i;

            }
            stack.push(i);
        }
        return ans;



    }
}
