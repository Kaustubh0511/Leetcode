class Solution {
    int[][] dp;
    int n;
    
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n][n + 1];
        return solve(0, n, cost, time);
    }
    
    public int solve(int i, int r, int[] cost, int[] time) {
        if (r <= 0) {
            return 0;
        }
        
        if (i == n) {
            return (int) 1e9;
        }
        
        if (dp[i][r] != 0) {
            return dp[i][r];
        }
        
        int take = cost[i] + solve(i + 1, r - 1 - time[i], cost, time);
        int notTake = solve(i + 1, r, cost, time);
        dp[i][r] = Math.min(take, notTake);
        return dp[i][r];
    }
}