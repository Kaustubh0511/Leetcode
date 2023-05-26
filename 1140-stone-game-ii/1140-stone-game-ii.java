class Solution {
    public int helper(int[] piles, int[][] dp, int[] ss, int i, int M) {
        if (i == piles.length) return 0;
        if (i + 2 * M >= piles.length) return ss[i];

        if (dp[i][M] != 0) return dp[i][M];

        int res = 0;
        for (int x = 1; x <= 2 * M; ++x) {
            res = Math.max(res, ss[i] - helper(piles, dp, ss, i + x, Math.max(M, x)));
        }

        dp[i][M] = res;
        return res;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];

        int[] ss = new int[n];
        ss[ss.length - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; --i) ss[i] = piles[i] + ss[i + 1];

        return helper(piles, dp, ss, 0, 1);
    }
}