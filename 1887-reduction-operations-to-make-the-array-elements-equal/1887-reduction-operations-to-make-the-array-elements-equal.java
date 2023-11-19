class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int cur = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                cur++;
            }
            
            res += cur;
        }
        
        return res;
    }
}