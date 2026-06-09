class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>l=new HashMap<>();
        for(int i=0;i<s.length();i++){
            l.put(s.charAt(i),i);
        }
        List<Integer>res=new ArrayList<>();
        int size=0;
        int end=0;

        for(int i=0;i<s.length();i++){
            size++;
            end=Math.max(end,l.get(s.charAt(i)));
            if(i == end){
                res.add(size);
                size=0;
            }
        }
        return res;
        
    }
}
