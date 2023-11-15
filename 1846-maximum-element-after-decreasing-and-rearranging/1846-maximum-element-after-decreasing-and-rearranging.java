class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int res = 1;
        for(int i =1;i<n;i++){
            if(arr[i] >= res+1){
                res++;
            }
        }
        
        return res;
    }
}