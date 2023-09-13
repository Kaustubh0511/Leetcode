class Solution {
    public int candy(int[] a) {
         int n = a.length; 
        
        int[] candy = new int[n]; 
        for (int i = 1; i < n; i++) {
            if (a[i - 1] < a[i] && candy[i - 1] >= candy[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (a[i + 1] < a[i] && candy[i + 1] >= candy[i]) {
                candy[i] = candy[i + 1] + 1;
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += candy[i] + 1;
        }
        
        return count;
    }
}