class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List < int[] > al = new ArrayList < > ();
        int[] current_interval = intervals[0];
        al.add(current_interval);

        for (int[] interval: intervals) {
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                current_interval = interval;
                al.add(current_interval);
            }
        }
       return al.toArray(new int[al.size()][]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] mat = new int[n+1][2];
        mat[0][0] = newInterval[0];
        mat[0][1] = newInterval[1];
        
        for(int i =1;i<mat.length;i++){
            mat[i][0] = intervals[i-1][0];
            mat[i][1] = intervals[i-1][1];
        }
        // for(int i=0;i<mat.length;i++){
        //     for(int j=0;j<2;j++){
        //         System.out.print(mat[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int[][] res = merge(mat);
        return res;
    }
}