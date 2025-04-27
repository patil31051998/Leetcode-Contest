class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKIndex = -1;
        int maxKIndex = -1;
        int invalidIndex = -1;
        int i;
        long count = 0L;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                invalidIndex = i;
            }
            if(nums[i] == minK) {
                minKIndex = i;
            }
            if(nums[i] == maxK) {
                maxKIndex = i;
            }
            count += Math.max(Math.min(minKIndex, maxKIndex) - invalidIndex, 0);
        }
        return count;
    }
}