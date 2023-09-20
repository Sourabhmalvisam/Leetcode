class Solution {
    public static int coinChange(int[] coins, int idx, int amount, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return amount / coins[idx];
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }
        int notTake = coinChange(coins, idx - 1, amount, dp);
        int take = (int)Math.pow(10,9);
        if (coins[idx] <= amount) {
            take = 1 + coinChange(coins, idx, amount - coins[idx], dp);
        }
        int ans = Math.min(notTake, take);
        dp[idx][amount] = ans;
        return ans;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = coinChange(coins, n - 1, amount, dp);
        if (ans >= (int)Math.pow(10,9)) {
            return -1;
        } else {
            return ans;
        }
    }
}
