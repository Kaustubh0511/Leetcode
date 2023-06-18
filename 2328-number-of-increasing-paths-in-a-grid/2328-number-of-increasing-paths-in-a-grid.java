class Solution {
    public int countPaths(int[][] grid) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length, n = grid[0].length;
        int mod = 1_000_000_007;
        
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,1));
        
        int[][] cellList = new int[m*n][2];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                int idx = i*n +j;
                cellList[idx][0] = i;
                cellList[idx][1] = j;
            }
        }
        Arrays.sort(cellList, (a,b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        for(int[] cell :cellList){
            int i = cell[0],j = cell[1];
            
            for(int[] d : dir){
                int curI = i + d[0], curJ = j +d[1];
                if(0 <= curI && curI<m && 0 <= curJ && curJ<n && grid[curI][curJ] > grid[i][j]){
                    dp[curI][curJ] += dp[i][j];
                    dp[curI][curJ] %= mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<m;++i){
            for(int j =0;j<n;++j){
                ans += dp[i][j];
                ans %= mod; 
            }
        }
        return ans;
    }
}