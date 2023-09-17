class Solution {
   
    public int coinChange(int[] coins, int amount) {
     int[][]   dp = new int[coins.length][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0) dp[0][j]=j/coins[0];
            else dp[0][j]=(int )Math.pow(10,9);
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){

        int notTake=dp[i-1][j];
        int take=(int)Math.pow(10,9);
      if (coins[i] <= amount && j - coins[i] >= 0) {
    take = 1 + dp[i][j-coins[i]]; // Use dp[i-1] here
}

        dp[i][j]=Math.min(take,notTake);
            }
        }
        int ans=dp[coins.length-1][amount];
        if(ans>=(int)Math.pow(10,9)) return -1;
        else return ans;
        
    }
}