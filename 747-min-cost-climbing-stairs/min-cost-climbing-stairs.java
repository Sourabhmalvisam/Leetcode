class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        
        return Math.min(rec(cost, 0, memo), rec(cost, 1, memo));
    }
    
    int rec(int[] cost, int index, int[] memo) {
       if(index >= cost.length)
           return 0;
        
        if(memo[index] == 0) {
            memo[index] = Math.min(rec(cost, index + 1, memo), rec(cost, index + 2, memo));
        }
        
        return cost[index] + memo[index];
    }
}