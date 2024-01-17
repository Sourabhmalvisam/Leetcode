class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       int countArr[]=new int[2001];
       boolean freqArr[]=new boolean[1001];
       for(int ele:arr){
           countArr[1000+ele]++;
       }
       for(int ele: countArr){
           if(ele!=0){ if(freqArr[ele]){
               return false;
           }
           freqArr[ele]= true;}
          
       }
       return true;

    }
}