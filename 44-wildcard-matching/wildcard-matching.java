class Solution { //Striver //DP
	public boolean isMatch(String S2, String S1) {
		int m = S1.length();
		int n = S2.length();

		boolean dp[][] = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int j = 1; j <= n; j++) {
			dp[0][j] = false;
		}

		for (int i = 1; i <= m; i++) {
			dp[i][0] = isAllStars(S1, i);
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
					dp[i][j] = dp[i - 1][j - 1];

				else {
					if (S1.charAt(i - 1) == '*')
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

					else
						dp[i][j] = false;
				}
			}
		}

		return dp[m][n];
	}

	private boolean isAllStars(String str, int end) {
		for (int i = 0; i < end; i++) {
			if (str.charAt(i) != '*') {
				return false;
			}
		}

		return true;
	}

}