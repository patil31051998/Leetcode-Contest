class Solution {
    public long countSubarrays(int[] nums, long k) {
        long[] prefixSum = new long[nums.length];
        long curr = 0L;
        int i;
        for(i = 0; i < nums.length; i++) {
            curr += nums[i];
            prefixSum[i] = curr;
        }
        int low, mid, high;
        long count = 0L;
        for(i = 0; i < nums.length; i++) {
            low = i;
            high = nums.length - 1;
            int validIndex = -1;
            while(low <= high) {
                mid = low + (high - low) / 2;
                if(isSumWithinRange(prefixSum, i, mid, k)) {
                    validIndex = mid;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            if(validIndex != -1) {
                count += (validIndex - i + 1);
            }
        }
        return count;
    }

    private boolean isSumWithinRange(long[] prefixSum, int left, int right, long k) {
        long leftSum = left == 0 ? 0 : prefixSum[left - 1];
        long rightSum = prefixSum[right];
        int count = right - left + 1;
        return (rightSum - leftSum) * (long)count < k;
    }
}