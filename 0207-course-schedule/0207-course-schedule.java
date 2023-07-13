class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            adj.get(i[1]).add(i[0]);
            indeg[i[0]]++; 
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        
        int visited = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            visited++;
            
            for(int nei : adj.get(node)){
                indeg[nei]--;
                if(indeg[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return visited == numCourses;
    }
}