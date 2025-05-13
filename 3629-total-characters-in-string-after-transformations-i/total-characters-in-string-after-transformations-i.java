class Solution {

    private final static int MOD = (int)Math.pow(10, 9) + 7;

    public int lengthAfterTransformations(String s, int t) {
        long[] currCount = new long[26];
        long[] newCount = new long[26];

        int i, j;
        long res = 0L;
        for(i = 0; i < s.length(); i++) {
            currCount[s.charAt(i) - 'a']++;
        }
        for(i = 1; i <= t; i++) {
            for(j = 0; j < 25; j++) {
                newCount[j + 1] = currCount[j];
            }
            newCount[0] = currCount[25];
            newCount[1] = (newCount[1] + currCount[25]) % MOD;
            long[] temp = currCount;
            currCount = newCount;
            newCount = temp;
        }
        for(i = 0; i < 26; i++) {
            res = (res + currCount[i]) % MOD;
        }
        return (int)res;
    }
}