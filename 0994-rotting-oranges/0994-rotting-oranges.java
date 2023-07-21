class Pair{
    int x;
    int y;
    int t;
    public Pair(int x,int y,int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        int t = 0;
        int maxt =0;
        int[][] vis = new int[n][m];
        for(int i= 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,t));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        // if(t == 0) return 0;
        int[] dx = {-1,0,1,0};
        int[] dy = { 0,1,0,-1};
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int r = cur.x;
            int c = cur.y;
            int ti = cur.t;
            maxt = Math.max(maxt,ti);
            for(int i =0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] != 2 && grid[nr][nc] == 1){
                    q.offer(new Pair(nr,nc,ti+1));
                    vis[nr][nc] = 2;
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(vis[i][j] != 2 && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return maxt;
    }
}