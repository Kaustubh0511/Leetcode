class Solution {
    int[] dp;
    public int integerBreak(int n) {
        int res = 0;
        if(n <= 3){
            return n-1;
        }
        
        dp = new int[n+1];
        return solve(n);
    }
    
    public int solve(int n){
        if(n <= 3){
            return n;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int res = n;
        for(int i = 2;i<n;i++){
            res = Math.max(res,i*solve(n-i));
        }
        
        dp[n] = res;
        return res;
    }
}