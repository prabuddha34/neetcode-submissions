class Solution {
    public int findLucky(int[] arr) {
       HashMap<Integer,Integer>map=new HashMap<>();
        int maxCount=-1;
        for(int arrs:arr){
                 map.put(arrs, map.getOrDefault(arrs, 0) + 1);
        }
        for(int key:map.keySet()){
            if(key == map.get(key)){
                maxCount=Math.max(maxCount,key);
            }
        }
        return maxCount;
    }
}