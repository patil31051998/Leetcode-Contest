class Solution {

    private final int MOD = (int)Math.pow(10, 9) + 7;

    public int numTilings(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int i;
        for(i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return numTilings(n, n, dp);
    }

    private int numTilings(int r1, int r2, int[][] dp) {
        if(r1 == 0 && r2 == 0) {
            return 1;
        }
        if(r1 < 0 || r2 < 0) {
            return 0;
        }
        if(dp[r1][r2] != -1) {
            return dp[r1][r2];
        }
        long res = 0;
        if(r1 == r2) {
            res += numTilings(r1 - 2, r2 - 2, dp); // -
            res += numTilings(r1 - 1, r2 - 1, dp); // |
            res += numTilings(r1 - 2, r2 - 1, dp); // `|
            res += numTilings(r1 - 1, r2 - 2, dp); // _|
        }
        else if(r1 > r2) {
            res += numTilings(r1 - 2, r2 - 1, dp); // |`
            res += numTilings(r1 - 2, r2, dp); // -
        }
        else {
            res += numTilings(r1 - 1, r2 - 2, dp); // |_
            res += numTilings(r1, r2 - 2, dp); // _
        }
        return dp[r1][r2] = (int)(res % MOD);
    }
}