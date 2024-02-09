class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] gs = new int[n];
        int[] pe = new int[n];
        int mI = 0;
        
        for(int i = 0;i<n;i++){
            gs[i] = 1;
            pe[i] = -1;
            for(int j = 0;j<i;j++){
                if(nums[i] %nums[j] == 0){
                    if(gs[i] < 1 + gs[j]){
                        gs[i] = 1+ gs[j];
                        pe[i] = j;
                    }
                }
            }
            if(gs[i] > gs[mI]){
                mI = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(mI != -1){
            res.add(0,nums[mI]);
            mI = pe[mI];
        }
        
        return res;
    }
}