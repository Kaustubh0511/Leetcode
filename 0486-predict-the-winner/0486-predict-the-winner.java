class Solution {
    int[][] memo;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return maxDiff(nums,0,n-1,n) >= 0;
    }
    private int maxDiff(int[] nums,int left ,int right,int n){
        if(memo[left][right] != -1)
            return memo[left][right];
        
        if(left == right)
            return nums[left];
        
        int ls = nums[left] - maxDiff(nums,left+1,right,n);
        int rs = nums[right] - maxDiff(nums,left,right-1,n);
        
        memo[left][right] = Math.max(ls,rs);
        
        return memo[left][right];
        
    }
}