class Solution { //Aditya Verma //Blind75 //Striver //LeetcodePatterns //DP
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Create a 2D array 'dp' for dynamic programming with dimensions (n+1) x (amount+1).
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize the first row (no items) and first column (no amount) of 'dp'.
        // Set dp[0][0] to 0 since no coins are needed for amount 0.
        // Set other values in the first row to Integer.MAX_VALUE-1 to indicate they are not possible.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if (j == 0)
                    dp[i][j] = 0;
            }
        }

        // Fill in the 'dp' array to compute the minimum number of coins needed.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    // If the current coin's value can be used, consider both options:
                    // 1. Including the current coin and adding 1 to the previous state (dp[i][j - coins[i - 1]]).
                    // 2. Excluding the current coin and keeping the previous state (dp[i - 1][j]).
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    // If the current coin's value is greater than the current amount, exclude it.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final value in dp[n][amount] represents the minimum number of coins needed.

        // Check if it's possible to make up the amount with the given coins.
        if (dp[n][amount] != Integer.MAX_VALUE - 1)
            return dp[n][amount];
        else
            return -1; // Return -1 if it's not possible to make up the amount.
    }
}
