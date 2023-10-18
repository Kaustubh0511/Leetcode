class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> gph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            gph.put(i, new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for (int[] edge: relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            gph.get(x).add(y);
            indegree[y]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] maxTime = new int[n];
        
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                q.add(node);
                maxTime[node] = time[node];
            }
        }
        
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int neighbor: gph.get(node)) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }

        return ans;
    }
    
}