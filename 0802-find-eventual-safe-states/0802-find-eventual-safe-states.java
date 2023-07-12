class Solution {
    public boolean dfs(int node,boolean[] visited,int[][] graph,int[] unSafe){
        boolean isSafe = true;
        for(int nei : graph[node]){
            if(visited[nei] || unSafe[nei] == 2){
                    isSafe = false;
                    break;
            }
            if(unSafe[nei] == 1) continue;
            visited[nei] = true;
            if(!dfs(nei,visited,graph,unSafe)) isSafe = false;
            visited[nei] = false;
        }
        unSafe[node] = isSafe ? 1 : 2;
        return isSafe;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        
        int[] unsafe = new int[n];
        for(int i =0;i<n;i++){
            if(unsafe[i] == 0){
                visited[i] = true;
                dfs(i,visited,graph,unsafe);
                visited[i] = false;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<unsafe.length;i++){
            if(unsafe[i] == 1) res.add(i);
        }
        return res;
    }
}