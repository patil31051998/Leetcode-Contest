class Solution {
    public int maxScore(String s) {
        int[] zeroCount = new int[s.length()];
        int[] oneCount = new int[s.length()];
        int i, count;
        count = 0;
        for(i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                count++;
            }
            zeroCount[i] = count;
        }
        count = 0;
        for(i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                count++;
            }
            oneCount[i] = count;
        }
        count = 0;
        for(i = 0; i < s.length() - 1; i++) {
            count = Math.max(count, zeroCount[i] + oneCount[i + 1]);
        }
        return count;
    }
}