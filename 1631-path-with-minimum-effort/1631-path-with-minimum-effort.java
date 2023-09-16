class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0,0});
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int diff = info[0];
            int x = info[1];
            int y = info[2];
            
            if (x == n - 1 && y == m - 1) {
                return diff;
            }
            
            for (int[] d : dir) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx >= 0 && newy >= 0 && newx < n && newy < m) {
                    int w = Math.max(Math.abs(heights[x][y] - heights[newx][newy]), diff);
                    if (w < dis[newx][newy]) {
                        dis[newx][newy] = w;
                        pq.offer(new int[]{w, newx, newy});
                    }
                }
            }
        }
        return 0;
    }
}