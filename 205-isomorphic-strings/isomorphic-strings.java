class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sToT [] = new int [128];
        int tToS [] = new int [128];

        Arrays.fill(sToT, -1);
        Arrays.fill(tToS,-1);
        for(int i=0;i<s.length();i++){
            int char1 = s.charAt(i);
            int char2= t.charAt(i);
            if(sToT[char1]==-1){
                sToT[char1]= char2;
            }
            if(tToS[char2]==-1){
                tToS[char2]=char1;
            }
            if(sToT[char1]!=char2 || tToS[char2]!=char1) return false;
        }
        return true;
    }
}