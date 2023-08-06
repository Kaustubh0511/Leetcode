class Solution {
    private final int mod = 1000000007;
    private Long[][] memo;
    public int numMusicPlaylists(int n, int goal, int k) {
        memo = new Long[goal+1][n+1];
        for(Long[] r : memo){
            Arrays.fill(r,-1L);
        }
        return (int)(dp(goal,n,k,n));
    }
    
    private long dp(int i,int j,int k,int n){
        if(i==0 && j == 0)
            return 1;
        
        if(i==0 || j == 0){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        memo[i][j] = (dp(i-1,j-1,k,n) * (n-j+1))%mod;
        
        if(j > k){
            memo[i][j] += (dp(i-1,j,k,n) * (j-k))%mod;
            memo[i][j] %= mod;
        }
        
        return memo[i][j];
    }
}