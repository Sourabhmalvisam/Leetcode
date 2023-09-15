class Solution {static int[][]dp;
    public static int solve(int i, int j){
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=solve(i,j-1);
        int up=solve(i-1,j);
        return dp[i][j]=left+up;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1);
    }
}