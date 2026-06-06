class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber==0){
            return "";
        }
        int n=columnNumber-1;
        return convertToTitle(n/26)+(char)('A'+n%26);
    }
}