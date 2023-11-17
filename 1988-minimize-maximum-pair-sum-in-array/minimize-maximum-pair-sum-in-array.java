class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length/2;i++){
            ans=Math.max(ans,nums[i]+nums[nums.length-i-1] );
        }
        return ans;
    }
}