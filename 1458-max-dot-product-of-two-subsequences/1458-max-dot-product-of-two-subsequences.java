class Solution {
    int[][] dp;
    
    public int solve(int i, int j, int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if (i == n || j == m) {
            return 0;
        }
        
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int take = nums1[i] * nums2[j] + solve(i + 1, j + 1, nums1, nums2);
        dp[i][j] = Math.max(take, Math.max(solve(i + 1, j, nums1, nums2), solve(i, j + 1, nums1, nums2)));
        return dp[i][j];
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int maxF = Integer.MIN_VALUE;
        int maxS = Integer.MIN_VALUE;
        int minF = Integer.MAX_VALUE;
        int minS = Integer.MAX_VALUE;
        
        for (int num: nums1) {
            maxF = Math.max(maxF, num);
            minF = Math.min(minF, num);
        }
        
        for (int num: nums2) {
            maxS = Math.max(maxS, num);
            minS = Math.min(minS, num);
        }
        
        if (maxF < 0 && minS > 0) {
            return maxF * minS;
        }
        
        if (minF > 0 && maxS < 0) {
            return minF * maxS;
        }
        
        dp = new int[nums1.length][nums2.length];
        return solve(0, 0, nums1, nums2);
    }
}