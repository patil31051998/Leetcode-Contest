class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithLessOrEqualSum(nums, goal) - numSubarraysWithLessOrEqualSum(nums, goal - 1);
    }
    
    
    private int numSubarraysWithLessOrEqualSum(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int left, right, sum, count;
        left = right = sum = count = 0;
        while(right < nums.length) {
            sum = sum + nums[right];
            if(sum > goal) {
                while(sum > goal) {
                    sum -= nums[left];
                    left++;
                }
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}