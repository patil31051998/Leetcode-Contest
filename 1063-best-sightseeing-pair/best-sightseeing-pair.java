class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] prevRes = new int[values.length];
        int prevMax = values[0];
        int i, res;
        res = Integer.MIN_VALUE;
        for(i = 1; i < values.length; i++) {
            prevRes[i] = prevMax;
            prevMax = Math.max(prevMax, values[i] + i);
        }
        // System.out.println(Arrays.toString(prevRes));
        for(i = 1; i < values.length; i++) {
            res = Math.max(res, prevRes[i] + values[i] - i);
            // System.out.println(res);
        }
        return res;
    }
}