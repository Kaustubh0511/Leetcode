class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }
        Collections.sort(edges,(a,b) -> Integer.compare(a[0],b[0]));
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        int min = 0;
        int num = 0;
        for(int[] e : edges){
            int d = e[0];
            int u = e[1];
            int v = e[2];
            
            int parentU = findParent(parent,u);
            int parentV = findParent(parent,v);
            
            if(parentU != parentV){
                parent[parentU] = parentV;
                min += d;
                num++;
                if(num == n -1){
                    break;
                }
            }
        }
        return min;
    }
    
    private int findParent(int[] parent,int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = findParent(parent,parent[x]);
        return parent[x];
    }
}