class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int m = pairs[0].length;
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[0],b[0]));
        int count = 0;
        int[] memo = new int[n];
        for(int i = 0;i<n;i++){
            count = Math.max(count,LPC(i,pairs,n,memo));
        }
        return count;
    }
    
    public int LPC(int i, int[][] pairs,int n, int[] memo){
        if(memo[i] != 0)
            return memo[i];
        memo[i] = 1;
        for(int j = i+1;j<n;j++){
            if(pairs[i][1] < pairs[j][0]){
                memo[i] = Math.max(memo[i], 1 + LPC(j,pairs,n,memo));
            }
        }
        return memo[i];
    }
}