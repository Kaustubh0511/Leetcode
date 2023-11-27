class Solution {
    int[][] memo;
    int n;
    int mod = (int)1e9+7;
    int[][] jmps = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n+1][10];
        int res = 0;
        for(int s = 0;s<10;s++){
            res = (res + dp(n-1,s))%mod;
        }
        return res;
    }
    public int dp(int n,int s){
        if(n == 0)
            return 1;
        
        if(memo[n][s] != 0){
            return memo[n][s];
        }
        int res = 0;
        for(int ns : jmps[s]){
            res = (res + dp(n-1,ns))%mod;
        }
        memo[n][s] = res;
        return res;
    }
}