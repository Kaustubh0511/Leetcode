class Solution {
    private int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n];
        return Math.min(dp(cost,n-1),dp(cost,n-2));
    }
    public int dp(int[] cost,int n){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        if(memo[n] != 0) return memo[n];
        memo[n] = cost[n] +Math.min(dp(cost,n-1),dp(cost,n-2));
        return memo[n];
    }
}