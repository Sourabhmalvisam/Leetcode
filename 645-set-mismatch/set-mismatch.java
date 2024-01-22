class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
       Set<Integer> set=new HashSet<>();
       int d=0;
       int currSum=0;
       for(int x: nums){
           if(set.contains(x)) {
               d=x;
           }
           currSum+=x;
           set.add(x);
       }
       int m=sum-(currSum-d);
       return new int[]{d,m};
       
    }
}