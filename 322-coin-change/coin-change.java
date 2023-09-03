import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1); // Initialize memoization array with -1 (unprocessed)

        int ans = helper(coins, amount, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return Integer.MAX_VALUE; // Impossible to make up the amount
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = helper(coins, amount - coin, memo);
            if (subProblem != Integer.MAX_VALUE) {
                res = Math.min(res, subProblem + 1);
            }
        }

        memo[amount] = res;
        return res;
    }
}
