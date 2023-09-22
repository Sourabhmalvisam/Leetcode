class Solution {

	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(dp[i][0], -1);
				Arrays.fill(dp[i][1], -1);
			}
		}

		return getAns(prices, n, 0, 0, k, dp);
	}

	public static int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
		if (ind == n || cap == 0)
			return 0; // base case
		if (dp[ind][buy][cap] != -1)
			return dp[ind][buy][cap];

		int profit = 0;

		if (buy == 0) { // We can buy the stock
			profit = Math.max(0 + getAns(Arr, n, ind + 1, 0, cap, dp),
				-Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
		}

		if (buy == 1) { // We can sell the stock
			profit = Math.max(0 + getAns(Arr, n, ind + 1, 1, cap, dp),
				Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
		}

		return dp[ind][buy][cap] = profit;
	}
}