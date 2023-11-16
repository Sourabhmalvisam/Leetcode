class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> set=new HashSet<>();
        for(String num: nums){
            set.add(num);
        }
        for(int i=0;i<=Math.pow(2,16);i++){
            String s=Integer.toBinaryString(i);
            if(s.length()==n&&!set.contains(s)) return s;
        }
        return "00";
    }
}