class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        int len=0;

      while(i>=0){
        if(s.charAt(i)==' ') i--;
        else break;
      }

      while(i>=0){
        if(s.charAt(i)==' ') break;
        else {
            i--;
            len++;
        }
      }
      return len;
    }
}