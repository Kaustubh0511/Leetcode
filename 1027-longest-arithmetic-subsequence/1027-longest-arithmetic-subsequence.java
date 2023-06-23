class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        int len = 0;
        for(int i=0;i<n;++i){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;++j){
                int diff = nums[j] - nums[i];
                dp[i].put(diff,dp[j].getOrDefault(diff,1)+1);
                len = Math.max(len, dp[i].get(diff));
            }
        }
        return len;
    }
}