class Solution {
    static int[][] dp;
    public static int solve(int[] coins,int idx, int total){
        if(idx==0){
            if(total%coins[0]==0) return total/coins[0];
            return (int)Math.pow(10,9);
        }
        if(dp[idx][total]!=-1) return dp[idx][total];
        int notTake=solve(coins, idx-1,total);
        int take=(int)Math.pow(10,9);
        if(coins[idx]<=total){
            take=1+solve(coins, idx,total-coins[idx]);
        }
        return dp[idx][total]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        int ans= solve(coins, coins.length-1,amount);
        if(ans!=(int)Math.pow(10,9)) return ans;
        else return -1;
    }
}