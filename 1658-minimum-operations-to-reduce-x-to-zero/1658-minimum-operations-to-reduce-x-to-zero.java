class Solution {
    public int minOperations(int[] nums, int x) {
        int t = -x;
        int n = nums.length;
        for(int num : nums) t += num;
        
        if(t == 0) return n;
        int max =0,cur = 0,left = 0;
        for(int r = 0;r<n;r++){
            cur += nums[r];
            while(left <= r && cur > t){
                cur -= nums[left];
                left++;
            }
            if(cur == t){
                max = Math.max(max,r - left + 1);
            }
        }
        if(max != 0)
            return n - max;
        else
            return -1;
    }
}