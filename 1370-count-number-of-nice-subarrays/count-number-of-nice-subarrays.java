class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysWithLessOrEqualSum(nums, k) - numberOfSubarraysWithLessOrEqualSum(nums, k - 1);
    }
    
    private int numberOfSubarraysWithLessOrEqualSum(int[] nums, int k) {
        int left, right, sum, count;
        left = right = sum = count = 0;
        while(right < nums.length) {
            sum += (nums[right] % 2);
            if(sum > k) {
                while(sum > k) {
                    sum -= (nums[left] % 2);
                    left++;
                }
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}