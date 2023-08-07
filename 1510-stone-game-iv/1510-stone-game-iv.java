class Solution {
   private boolean[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new boolean[n+1];
        for(int i =0;i<n+1;i++){
            for(int k = 1;k * k <=i;k++){
                if(memo[i-k*k] == false){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}