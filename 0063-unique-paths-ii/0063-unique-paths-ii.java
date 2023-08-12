class Solution {
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        return solve(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }
    public int solve(int[][] a,int m,int n){
        if(m<0 || n<0)
            return 0;
        if(a[m][n] == 1)
            return 0;
        
        if (m == 0 && n==0 && (a[m][n] == 0))
            return 1;
        if(dp[m][n] != 0)
            return dp[m][n];
        
        int r = solve(a,m-1,n);
        int c = solve(a,m,n-1);
        
        return dp[m][n] = r + c; 
    }
}