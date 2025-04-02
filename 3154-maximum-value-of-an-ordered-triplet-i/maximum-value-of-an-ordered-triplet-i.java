class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] rightMax = new int[nums.length];
        int i, currMax;
        long res;
        currMax = Integer.MIN_VALUE;
        for(i = nums.length - 1; i >= 0; i--) {
            currMax = Math.max(currMax, nums[i]);
            rightMax[i] = currMax;
        }
        currMax = nums[0];
        res = 0L;
        for(i = 1; i < nums.length - 1; i++) {
            res = Math.max(res, 1L * (currMax - nums[i]) * rightMax[i + 1]);
            currMax = Math.max(currMax, nums[i]);
        }
        return res;
    }
}