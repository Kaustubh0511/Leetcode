class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int row = mat.length;
        int col = mat[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 0){
                     q.offer(new int[]{i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        
        int len = 0;
        while(!q.isEmpty()){
            int n = q.size();
            len++;
            while(n-- > 0){
                int[] front = q.poll();
                int r = front[0];
                int c = front[1];
                for(int i=0;i<4;i++){
                    int nr = r + dirX[i];
                    int nc = c + dirY[i]; 
                    if(nr < 0 || nc < 0 || nr >= row || nc >= col|| mat[nr][nc] >=0){
                        continue;
                    }
                    mat[nr][nc] = len;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
}