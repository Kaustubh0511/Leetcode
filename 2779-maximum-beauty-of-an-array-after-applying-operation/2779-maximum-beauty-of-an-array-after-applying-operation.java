class Solution {
   public int BS(int[] nums,int value){
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    public int maximumBeauty(int[] nums, int k) {
       int n = nums.length;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int range = k*2 + nums[i];
            int ub = BS(nums,range+1);
            int indx = ub - i;
            max = Math.max(max,indx);
        }
        return max;
    }
}