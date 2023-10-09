class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fi = -1;
        int li = -1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                fi = i;
                while(i < nums.length && nums[i] == target) {
                    i++;
                }
                li = i - 1;
                return new int[]{fi, li};
            }
        }
        return new int[]{fi, li};
    }
}