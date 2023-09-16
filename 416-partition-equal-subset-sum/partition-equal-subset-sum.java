class Solution {
  
    public static boolean subsetSum(int arr[], int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the base cases:
        // - An empty subset can achieve a sum of 0, so set those values to true.
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        // Fill in the 'dp' array to compute whether the target sum is achievable.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element can be included, check if the sum is achievable
                    // either by including the element or excluding it.
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // If the current element is larger than the sum, exclude it.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final value in dp[n][sum] represents whether the target sum is
        // achievable.
        return dp[n][sum];
    }
    public boolean canPartition(int[] arr) {
         int sum = 0;
        int n = arr.length;

        // Calculate the sum of all elements in the input array.
        for (int ele : arr) {
            sum += ele;
        }

        // If the total sum is odd, equal partition is not possible.
        if (sum % 2 == 1)
            return false;
        else
            return subsetSum(arr, sum / 2, n);
    }
}