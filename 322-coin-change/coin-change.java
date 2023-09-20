class Solution {
    public static int solve(int arr[], int idx, int amount,int[][]dp){
        if(idx==0){
            if(amount%arr[idx]==0) return amount/arr[idx];
            else return (int)Math.pow(10,9);
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake=solve(arr,idx-1,amount,dp);
        int take=(int)Math.pow(10,9);
        if(arr[idx]<=amount) take=1+solve(arr,idx,amount-arr[idx],dp);
        int ans=Math.min(notTake, take);
        return dp[idx][amount]=ans;
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        int ans= solve(coins, coins.length-1,amount,dp);
        if(ans>=(int)Math.pow(10,9))
        return -1; else return ans;
    
    }
}