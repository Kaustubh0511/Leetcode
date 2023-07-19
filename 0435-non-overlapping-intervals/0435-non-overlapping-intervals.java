class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[1]));
        int n = intervals.length;
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            
            if(x >= prev){
                prev = y;
            }
            else{
                count++;
            }
        }
        
        return count;
    }
}