class Solution {
    public int maxAscendingSum(int[] nums) {
        int max, sum, i;
        max = sum = nums[0];
        for(i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                sum += nums[i];
            }
            else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}