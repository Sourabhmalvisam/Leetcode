class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int len=pref.length();
       
        int count=0;
        for(String word: words){
            int length=word.length();
         if(length>=len){     String str=word.substring(0,len);
            if(str.equals(pref)) count++;}
       
        }
        return count;
    }
}