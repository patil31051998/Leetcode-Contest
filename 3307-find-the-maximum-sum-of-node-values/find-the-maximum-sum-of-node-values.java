class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long result = 0L;
        int incrementCount = 0;
        int minLoss = Integer.MAX_VALUE;
        for(int num : nums) {
            result += Math.max(num, num ^ k);
            incrementCount += (num ^ k) > num ? 1 : 0;
            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }
        return incrementCount % 2 == 0 ? result : result - minLoss;
    }
}