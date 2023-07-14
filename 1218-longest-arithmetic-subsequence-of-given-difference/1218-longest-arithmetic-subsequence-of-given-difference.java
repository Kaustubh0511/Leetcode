class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        int ans = 1;
        
        for(int a : arr){
            int prev = dp.getOrDefault(a - difference,0);
            dp.put(a,prev + 1);
            ans = Math.max(ans,dp.get(a));
        }
        return ans;
    }
}