class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] a = new double[102][102];
        a[0][0] = (double)poured;
        for(int r = 0;r<=query_row;r++){
            for(int c =0 ;c<=r;c++){
                double q = (a[r][c] - 1.0) /2.0;
                if(q > 0){
                    a[r+1][c] += q;
                    a[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1,a[query_row][query_glass]);
    }
}