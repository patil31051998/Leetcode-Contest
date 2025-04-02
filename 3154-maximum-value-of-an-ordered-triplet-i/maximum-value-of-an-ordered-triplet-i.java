class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int i, currMax;
        long res;
        currMax = Integer.MIN_VALUE;
        for(i = 0; i < nums.length; i++) {
            currMax = Math.max(currMax, nums[i]);
            leftMax[i] = currMax;
        }
        currMax = Integer.MIN_VALUE;
        for(i = nums.length - 1; i >= 0; i--) {
            currMax = Math.max(currMax, nums[i]);
            rightMax[i] = currMax;
        }
        res = 0L;
        for(i = 1; i < nums.length - 1; i++) {
            res = Math.max(res, 1L * (leftMax[i - 1] - nums[i]) * rightMax[i + 1]);
        }
        return res;
    }
}