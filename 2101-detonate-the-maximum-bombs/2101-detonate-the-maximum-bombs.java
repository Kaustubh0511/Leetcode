class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int n = bombs.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];
                
                if((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)){
                    hm.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,bfs(i,hm));
        }
        return ans;
    }
    private int bfs(int i,Map<Integer,List<Integer>> hm){
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> res = new HashSet<>();
        dq.offer(i);
        res.add(i);
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int entry : hm.getOrDefault(cur, new ArrayList<>())) {
                if (!res.contains(entry)) {
                    res.add(entry);
                    dq.offer(entry);
                }
            }
        }
        return res.size();
    }
}