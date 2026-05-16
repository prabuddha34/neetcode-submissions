class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        List<Integer>result=new ArrayList<>();


        for(int num:nums){
                map.put(num , map.getOrDefault(num, 0) + 1);
        }
          for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                result.add(key);
            }
        }

        return result;
    }
}