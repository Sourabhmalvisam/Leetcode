class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int x: nums){
            sum+=x;
            maxi=Math.max(sum, maxi);
            if(sum<0) sum=0;
        }
        return maxi;
    }
}