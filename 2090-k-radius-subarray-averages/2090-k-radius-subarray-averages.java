class Solution {
    //for(int i=0;i<n;i++){
        //     int l = i-0;
        //     int r = n - i;
        //     if(l<k){
        //         a[i] = -1;
        //     }
        //     else if(r<=k){
        //         a[i] = -1;
        //     }
        //     else{
        //         int p =0;
        //         for(int j=i-k;j<i+k+1;j++){
        //             sum += nums[j];
        //             avg = Math.floor(sum/(2*k+1));
        //             a[i] = (int)avg;
        //         }
        //         //System.out.print(sum+" ");
        //         sum =0;
        //         p++;
        //     }
        // }
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int size = (2*k)+1;
        long[] ps = new long[n+1];
        int[] a = new int[n];
        Arrays.fill(a, -1);
        
        for(int i=0;i<n;i++){
            ps[i+1] = ps[i] + nums[i];
            //System.out.print(ps[i]+" ");
        }
        for(int i =k;i+k<n;i++){
            a[i] = (int) ((ps[i + k + 1] - ps[i - k]) / size);
        }
        return a;
    }
}