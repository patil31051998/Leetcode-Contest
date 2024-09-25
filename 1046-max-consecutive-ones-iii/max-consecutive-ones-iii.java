class Solution {
    public int longestOnes(int[] nums, int k) {
        int left, right, count, max;
        left = right = count = max = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                if(count == k) {
                    while(nums[left] != 0) {
                        left++;
                    }
                    left++;
                }
                else {
                    count++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}