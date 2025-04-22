class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min, max, curr;
        min = max = curr = 0L;
        for(int diff : differences) {
            curr += diff;
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }
        long res = (upper - lower) - (max - min) + 1;
        return res > 0 ? (int) res : 0;
    }
}