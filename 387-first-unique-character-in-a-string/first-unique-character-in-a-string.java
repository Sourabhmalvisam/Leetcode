class Solution {
    public int firstUniqChar(String s) {
        int[] ans=new int[26];
        char [] arr=s.toCharArray();
        for(char ch: arr){
           ans[ch-'a']++;
        }
       for(int i=0;i<arr.length;i++){
           if(ans[arr[i]-'a']==1) return i;
       }
       return -1;
    }
}