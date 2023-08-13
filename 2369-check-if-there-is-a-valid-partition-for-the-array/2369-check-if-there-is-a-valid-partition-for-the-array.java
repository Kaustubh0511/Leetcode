class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();
    
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        memo.put(-1,true);
        return solve(0,n,nums);
    }
    public boolean solve(int i,int n,int[] nums){
        if(i>=n)
            return true;
        if(memo.containsKey(i))
            return memo.get(i);
        
        boolean res = false;
        if(i+1 < n && nums[i] == nums[i+1])
            res |= solve(i+2,n,nums);
        if(i+2 < n && nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
            res |= solve(i+3,n,nums);
        if(i+2 < n && nums[i+1]- nums[i] == 1 && nums[i+2] - nums[i+1] == 1)
            res |= solve(i+3,n,nums);
        
         memo.put(i,res);
        return res;
    } 
}