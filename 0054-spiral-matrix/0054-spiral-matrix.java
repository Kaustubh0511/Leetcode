class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> l = new ArrayList<Integer>();
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int total  = m*n;
        int sr = 0;
        int sc = 0;
        int er = m-1;
        int ec = n-1;
        while(count<total){
            for(int i=sc;count<total && i<=ec;i++){
                l.add(mat[sr][i]);
                count++;
            }
            sr++;
            for(int i=sr;count<total && i<=er;i++){
                l.add(mat[i][ec]);
                count++;
            }
            ec--;
            for(int i=ec;count<total && i>=sc;i--){
                l.add(mat[er][i]);
                count++;
            }
            er--;
            for(int i=er;count<total && i>=sr;i--){
                l.add(mat[i][sc]);
                count++;
            }
            sc++;
        }
        return l;
    }
}