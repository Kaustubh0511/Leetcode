class Solution {
    private int[][] memo;
    private int[] coins;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        int n = coins.length;
        memo = new int[n][amount+1];
        for(int[] r : memo){
            Arrays.fill(r,-1);
        }
        int start = 0;
        return dp(start,amount);
    }
    public int dp(int start,int amount){
        if(amount == 0){
            return 1;
        }
        if(start == coins.length)
            return 0;
        if(memo[start][amount] != -1){
            return memo[start][amount];
        }
        if(coins[start] > amount)
            return memo[start][amount] = dp(start+1,amount);
        
        memo[start][amount] = dp(start,amount-coins[start]) + dp(start+1,amount);
        return memo[start][amount];
    }
}