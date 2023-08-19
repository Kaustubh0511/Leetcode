class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEd = new int[m][4];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                newEd[i][j] = edges[i][j];
            }
            newEd[i][3] = i;
        }
        
        Arrays.sort(newEd,Comparator.comparingInt(edge -> edge[2]));
        
        UnionFind ufstd = new UnionFind(n);
        int wei = 0;
        for(int[] e : newEd){
            if(ufstd.union(e[0],e[1])){
                wei += e[2];
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<2;i++){
            res.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            UnionFind ufig = new UnionFind(n);
            int iw = 0;
            for(int j = 0 ;j<m;j++){
                if(i != j && ufig.union(newEd[j][0],newEd[j][1]))
                    iw += newEd[j][2];
            }
            if(ufig.maxSize < n || iw > wei){
                res.get(0).add(newEd[i][3]);
            }
            else{
                 UnionFind uff = new UnionFind(n);
                uff.union(newEd[i][0] ,newEd[i][1]);
                int fw = newEd[i][2];
                for(int j=0;j<m;j++){
                    if(i != j && uff.union(newEd[j][0],newEd[j][1])){
                        fw += newEd[j][2];
                    }  
                }
                if(fw == wei){
                    res.get(1).add(newEd[i][3]);
                }
            }
        }
        return res;
    }
    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) { 
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
           
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);
                return true;
            }
            return false;
        }
    }
}