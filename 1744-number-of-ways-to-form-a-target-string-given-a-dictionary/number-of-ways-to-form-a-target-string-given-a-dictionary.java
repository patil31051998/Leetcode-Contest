class Solution {
    private final int MOD = (int)Math.pow(10, 9) + 7;

    public int numWays(String[] words, String target) {
        int[][] charCount = new int[words[0].length()][26];
        int[][] dp = new int[target.length()][words[0].length()];
        int i, j;
        for(i = 0; i < target.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        for(i = 0; i < words.length; i++) {
            for(j = 0; j < words[0].length(); j++) {
                charCount[j][words[i].charAt(j) - 'a']++;
            }
        }
        return numWays(target, 0, 0, charCount, dp);
    }

    private int numWays(String target, int ind, int col, int[][] charCount, int[][] dp) {
        if(ind == target.length()) {
            return 1;
        }
        if(col == charCount.length || target.length() - ind > charCount.length - col) {
            return 0;
        }
        if(dp[ind][col] != -1) {
            return dp[ind][col];
        }
        long notPick = numWays(target, ind, col + 1, charCount, dp) % MOD;
        long pick = 0L;
        if(charCount[col][target.charAt(ind) - 'a'] > 0) {
            pick = (charCount[col][target.charAt(ind) - 'a'] * 1L *
                        numWays(target, ind + 1, col + 1, charCount, dp)) % MOD;
        }
        return dp[ind][col] = (int)((notPick + pick) % MOD);
    }
}