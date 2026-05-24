class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int cars[][]=new int[n][2];

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        //(1,3)(4,5)(7,1)

        //x IS THE position and Y is the sprotected
                Arrays.sort(cars, (a, b) -> b[0] - a[0]);

            int fleets=0;
            double  lastTime=0;

            for(int i=0;i<n;i++){
                double time=(double)(target - cars[i][0]) / cars[i][1];
                if(time>lastTime){
                      fleets++;
                lastTime = time;
                }
            
            }
            return fleets;
    }
}
