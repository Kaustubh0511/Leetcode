class Solution {
    Integer[] memo;
    HashSet<String> ds;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        ds = new HashSet<>(Arrays.asList(dictionary));
        return dp(0,n,s);
    }
    
    private int dp(int i,int n,String s){
        if(i == n)
            return 0;
        if(memo[i] != null)
            return memo[i];
        
        int ans = dp(i+1,n,s)+1;
        
        for(int j = i;j<n;j++){
            var curr = s.substring(i,j+1);
            if(ds.contains(curr)){
                ans = Math.min(ans,dp(j+1,n,s));
            }
        }
        
        return memo[i] = ans;
    }
}