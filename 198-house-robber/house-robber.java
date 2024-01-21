class Solution {
    
    public int rob(int[] nums) {
      int[]  dp=new int[nums.length];
        Arrays.fill(dp,-1);
      dp[0]=nums[0];
      for(int i=1;i<nums.length;i++){
          int pick=nums[i];
          if(i-2>=0) pick+=dp[i-2];
          int notPick=dp[i-1];
          dp[i]=Math.max(pick,notPick);
      }
      return dp[nums.length-1];
    }
}