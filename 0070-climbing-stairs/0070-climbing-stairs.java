class Solution {
    private HashMap<Integer,Integer> memo;
    public int climbStairs(int n) {
        memo = new HashMap<>();
        return dp(n);
    }
    public int dp(int n){
        if(n < 0)
            return 0;
        if(n == 0 || n == 1) return 1;
        if(!memo.containsKey(n)){
            memo.put(n,dp(n-1)+dp(n-2));
        }
        return memo.get(n);
    }
}