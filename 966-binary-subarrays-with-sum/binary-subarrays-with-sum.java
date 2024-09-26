class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i, count;
        count = 0;
        for(i = 0; i < nums.length; i++) {
            int left, right, sum;
            left = right = i;
            sum = 0;
            while(right < nums.length) {
                sum += nums[right];
                if(sum > goal) {
                    break;
                }
                else if(sum == goal) {
                    count++;
                }
                right++;
            }
        }
        return count;
    }
}