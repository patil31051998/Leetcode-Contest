class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal, i, left, right, count;
        long res = 0L;
        maxVal = -1;
        for(i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        left = 0;
        right = 0;
        count = 0;
        while(right < nums.length) {
            if(nums[right] == maxVal) {
                count++;
            }
            if(count == k) {
                while(nums[left] != maxVal) {
                    res += (nums.length - right);
                    left++;
                }
                res += (nums.length - right);
                left++;
                count--;
            }
            right++;
        }
        return res;
    }
}