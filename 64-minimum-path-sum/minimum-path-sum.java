class Solution {
    static int dp[][];
    public static int solve(int [][] grid, int i, int j){
        if(i<0||j<0||i==grid.length||j==grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1&&j==grid[0].length-1) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down=solve(grid, i+1,j);
        int right=solve(grid,i,j+1);
        int min=Math.min(down, right);
        return dp[i][j]=min+grid[i][j];

    }
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(grid, 0,0);
    }
}