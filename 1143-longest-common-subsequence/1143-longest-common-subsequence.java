class Solution {
     int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        memo = new int[n+1][m+1];
        for(int[] r : memo) Arrays.fill(r,-1);
        return solve(text1,text2,n,m);
    }
    
    public int solve(String a, String b,int n,int m){
        if(m == 0 || n == 0)
            return 0;
        if(memo[n][m] != -1)
            return memo[n][m];
        
        if(a.charAt(n-1) == b.charAt(m-1))
            return memo[n][m] =  1 + solve(a,b,n-1,m-1);
        
        else 
            return memo[n][m] =  Math.max(solve(a,b,n-1,m),solve(a,b,n,m-1)); 
    }
}