class Solution {
    static int dp[];
    public static int solve(int nums[],int idx){
        if(idx<0) return 0;
        if(idx==0) return nums[idx];
        if(dp[idx]!=-1) return dp[idx];
        int pick = nums[idx]+solve(nums, idx-2);
        int notpick=solve(nums, idx-1);
        int max=Math.max(pick, notpick);
        return dp[idx]=max;

    }
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums, nums.length-1);
    }
}