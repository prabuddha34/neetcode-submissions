
class Solution {
    public int maxDifference(String s) {
        //I made the HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int oddMax=0;
        int evenMin=Integer.MAX_VALUE;
        for(int freq:map.values()){
            if(freq%2!=0){
                oddMax = Math.max(oddMax, freq);
            }
            else{
                evenMin = Math.min(evenMin, freq);
            }
        }

        return oddMax-evenMin;
    }
}