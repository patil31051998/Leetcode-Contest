class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prevMax = values[0];
        int i, res;
        res = Integer.MIN_VALUE;
        for(i = 1; i < values.length; i++) {
            res = Math.max(res, prevMax + values[i] - i);
            prevMax = Math.max(prevMax, values[i] + i);
        }
        return res;
    }
}