class Solution {
    public int numDistinct(String t, String s) {
         int dp[][] = new int[t.length()][s.length()];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return countUtil(t, s, t.length() - 1, s.length() - 1, dp);
    }
     static int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind2 < 0)
            return 1;
        if (ind1 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            return dp[ind1][ind2] = (leaveOne + stay);
        }

        else {
            return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
    }
}