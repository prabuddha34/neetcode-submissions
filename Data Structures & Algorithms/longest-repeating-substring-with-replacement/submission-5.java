class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;

        int count[]=new int[26];
        int maxCount=0;
        int answer=0;

        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

            count[ch-'A']++;

            int windowSize=right-left+1;
            
            maxCount=Math.max(maxCount,count[ch-'A']);

            if(windowSize-maxCount>k){
            
            count[s.charAt(left) - 'A']--;
            left++;
            }
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
