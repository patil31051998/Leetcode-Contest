class Solution {
    private final int MOD = (int)Math.pow(10, 9) + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return countGoodStrings(low, high, zero, one, 0, dp);
    }

    private int countGoodStrings(int low, int high, int zero, int one, int currCount, int[] dp) {
        if(currCount > high) {
            return 0;
        }
        if(dp[currCount] != -1) {
            return dp[currCount];
        }
        int currVal = currCount >= low && currCount <= high? 1 : 0;
        int zeroVal = countGoodStrings(low, high, zero, one, currCount + zero, dp) % MOD;
        int oneVal = countGoodStrings(low, high, zero, one, currCount + one, dp) % MOD;
        return dp[currCount] = (currVal + zeroVal + oneVal) % MOD;
    }
}