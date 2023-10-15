class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= steps; i++) {
            for (int j = arrLen - 1; j >= 0; j--) {
                int ans = dp[j][i - 1];
                
                if (j > 0) {
                    ans = (ans + dp[j - 1][i - 1]) % mod;
                }
                
                if (j < arrLen - 1) {
                    ans = (ans + dp[j + 1][i - 1]) % mod;
                }
                
                dp[j][i] = ans;
            }
        }
        
        return dp[0][steps];
    }
}