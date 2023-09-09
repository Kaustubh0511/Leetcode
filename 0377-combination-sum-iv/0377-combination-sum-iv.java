public class Solution {
    private static final int MAX_TARGET = 1010; // Maximum possible target value
    private int[] dp = new int[MAX_TARGET]; // Array to store computed results

    private int countCombinations(int[] nums, int remainingTarget) {
        if (remainingTarget == 0)
            return 1;
        
        if (remainingTarget < 0)
            return 0;
        
        if (dp[remainingTarget] != -1)
            return dp[remainingTarget];
        
        int currentCombinations = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            // Recursively calculate combinations for the new target.
            currentCombinations += countCombinations(nums, remainingTarget - currentNum);
        }
        
        // Store and return the computed result.
        return dp[remainingTarget] = currentCombinations;
    }

    public int combinationSum4(int[] nums, int target) {
       for (int i = 0; i < MAX_TARGET; i++) {
            dp[i] = -1;
        }
        
        return countCombinations(nums, target);
    }
}