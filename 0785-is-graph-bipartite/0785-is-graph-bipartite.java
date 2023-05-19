class Solution {
    public boolean isBipartite(int[][] graph) {
        // return false;
        int n = graph.length;
        int[] c = new int[n];
        for(int node =0;node<n;node++){
            if(c[node] != 0){
                continue;
            }

            Queue<Integer> q = new ArrayDeque<>();
            q.add(node);
            c[node] = 1;

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int ele:graph[curr]){
                    if(c[ele]==0){
                        c[ele]= -c[curr];
                        q.add(ele);
                    }
                    else if(c[ele] != -c[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}