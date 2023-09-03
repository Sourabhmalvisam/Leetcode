class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
      return helper(0,0,m,n,dp);
       
    }
    public static int helper(int r, int c, int m, int n,int[][]dp){
        if(r<0||c<0||r>=m||c>=n) return 0;
       else  if(r==m-1&&c==n-1) return 1;
       if(dp[r][c]!=0) return dp[r][c];
       dp[r][c]=helper(r+1,c,m, n,dp)+helper(r,c+1,m,n,dp);
       return dp[r][c];
        
    }
}