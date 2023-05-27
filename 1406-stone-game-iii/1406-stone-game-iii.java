class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[3];

        for(int i=n-1;i>=0;i--){
            int one  = stoneValue[i] - dp[ (i+1) % 3];
            int two = Integer.MIN_VALUE;
            if(i+1 < n){
                two = stoneValue[i] + stoneValue[i+1] - dp[(i+2)%3];
            }
            int three = Integer.MIN_VALUE;
            if(i+2 < n){
                three = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[(i+3)%3];
            }
            dp[i%3] = Math.max(one,Math.max(two,three));
        }
        int diff = dp[0];
        if(diff>0){
            return "Alice";
        }
        else if(diff<0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
}