class Solution {
    public int hist(int[] b){
        if(b.length ==0 || b == null){
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int i =0;
        while(i<b.length){
            if(s.isEmpty() || b[i] > b[s.peek()]){
                s.push(i);
                i++;
            }
            else{
                int p = s.pop();
                int h = b[p];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(h*w,max);
            }
        }
        while(!s.isEmpty()){
            int p = s.pop();
            int h = b[p];
            int w = s.isEmpty() ? i : i - s.peek() - 1;
            max = Math.max(h*w,max);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] a = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = Character.getNumericValue(matrix[i][j]); 
                // System.out.print(a[i][j]+" ");
            }
            // System.out.println();
        }
        int cur[] = a[0];
        int max = hist(cur);
        for(int i =1;i<n;i++){
            for(int j =0;j<m;j++){
                if(a[i][j] == 1){
                    cur[j] += 1;
                }
                else{
                    cur[j] = 0;
                }
            }
            int ans = hist(cur);
            max = Math.max(max,ans);
        }
        return max;
    }
}