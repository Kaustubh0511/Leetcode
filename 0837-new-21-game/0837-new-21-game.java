class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0||n>=k+maxPts){
            return 1.0;
        }
        double ws = 1.0;
        double prob = 0.0;
        double[] dp = new double[n+1];
        dp[0] = 1.0;
        for(int i=1;i<dp.length;i++){
            dp[i] = ws/maxPts;
            if(i<k){
                ws += dp[i];
            }
            else{
                prob += dp[i];
            }
            if(i-maxPts>=0){
                ws -= dp[i-maxPts];
            }
        }
        return prob;
    }
}