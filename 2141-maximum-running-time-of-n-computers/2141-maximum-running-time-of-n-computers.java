class Solution {
    public boolean isFeasible(int n,int[] batteries,long m){
        long d = 0;
        for(int i : batteries){
            if(i < m) d += i;
            else d += m;
        }
        return d >= n*m;
        
    }
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int i : batteries){
            sum += i;
        }
        long low = 0,high= sum,ans=0;
        
        while(low <= high){
            long mid = (low+high)/2;
            if(isFeasible(n,batteries,mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return ans;
    }
}