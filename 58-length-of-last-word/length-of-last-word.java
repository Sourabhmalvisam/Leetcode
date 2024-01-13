class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        char[] arr=s.toCharArray();
        int len=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=' ') len++;
            else break;
        }
        return len;
        
    }
}