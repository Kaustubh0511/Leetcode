class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = n;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        
        int[] nn = new int[hs.size()];
        int idx = 0;
        
        for(int i : hs){
            nn[idx++] = i;
        }
        
        Arrays.sort(nn);
        
        for(int i=0;i<nn.length;i++){
            int l = nn[i];
            int r = l + n -1;
            int j = binarySearch(nn,r);
            int cnt = j -i;
            res = Math.min(res,n - cnt);
        }
        return res;
    }
    
    public int binarySearch(int[] nn,int t){
        int l = 0;
        int r = nn.length;
        
        while(l < r){
            int m = (l+r)/2;
            if(t < nn[m]){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
}