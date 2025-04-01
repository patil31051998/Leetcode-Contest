class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1L);
        return mostPoints(0, questions, dp);
    }

    private long mostPoints(int ind, int[][] questions, long[] dp) {
        if(ind >= questions.length) {
            return 0;
        }
        if(dp[ind] != -1L) {
            return dp[ind];
        }
        long pick, notPick;
        notPick = 0L + mostPoints(ind + 1, questions, dp);
        pick = 0L + questions[ind][0] +  mostPoints(ind + questions[ind][1] + 1, questions, dp);
        return dp[ind] = Math.max(notPick, pick);
    }
}