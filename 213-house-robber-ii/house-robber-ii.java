class Solution {
    public int rob(int[] arr) {
        
    int n = arr.length;
    if(n==1) return arr[0];
        int ans1 = houseRobbarBottomUp(Arrays.copyOfRange(arr, 1, n));
        int ans2 = houseRobbarBottomUp(Arrays.copyOfRange(arr, 0, n - 1));

        return Math.max(ans1, ans2);
    }
  static int houseRobbarBottomUp(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}