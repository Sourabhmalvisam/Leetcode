class Solution {
    static int[][]dp;
    public static int solve(int idx, int amount, int []coins){
        if(idx==0){
            if(amount%coins[0]==0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake=solve(idx-1, amount, coins);
        int take=0;
        if(coins[idx]<=amount){
            take=solve(idx,amount-coins[idx],coins);
        }
        return dp[idx][amount]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(coins.length-1, amount, coins);
    }
}