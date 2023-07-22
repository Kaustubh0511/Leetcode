class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] cur = new double[n][n];
        double[][] next = new double[n][n];
        cur[row][column] = 1.0;
        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        if(k == 0){
            return 1;
        }
        for(int m = 0;m<k;m++){
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(cur[i][j] != 0){
                        for(int l =0;l<8;l++){
                            int nr = i + dx[l];
                            int nc = j + dy[l]; 
                            
                            if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                                next[nr][nc] += cur[i][j]/8.0;
                            }
                        }
                    }
                }
            }
            cur = next;
            next = new double[n][n]; 
        }
        
        double prob =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                prob += cur[i][j];
            }
        }
        return prob;
    }
}