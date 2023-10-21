class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return b[0] - a[0];
        });
        
        q.add(new int[]{nums[0],0});
        int res = nums[0];
        
        for(int i =1 ;i<nums.length;i++){
            while(i - q.peek()[1] > k){
                q.remove();
            }
            int cur = Math.max(0,q.peek()[0]) + nums[i];
            res  = Math.max(res,cur);
            q.add(new int[]{cur,i});
        }
        return res;
    }
}