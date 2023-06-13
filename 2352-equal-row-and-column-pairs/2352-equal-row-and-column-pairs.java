class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<String,Integer> m = new HashMap<>();
        
        for(int[] rows : grid){
            String key = Arrays.toString(rows);
            m.put(key,m.getOrDefault(key,0)+1);
        }
        
        for(int i = 0;i<n;i++){
            int[] col = new int[n];
            for(int j=0;j<n;j++){
                col[j] = grid[j][i];
            }
            String key = Arrays.toString(col);
            count += m.getOrDefault(key,0);
            
        }
        return count;
    }
}