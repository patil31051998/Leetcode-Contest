class Solution {
    public int waysToSplitArray(int[] nums) {
        int i, count;
        long leftSum, rightSum;
        long[] leftArr = new long[nums.length];
        long[] rightArr = new long[nums.length];
        leftSum = rightSum = 0L;
        count = 0;
        for(i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            leftArr[i] = leftSum;
            rightSum += nums[nums.length - 1 - i];
            rightArr[nums.length - 1 - i] = rightSum;
        }
        for(i = 0; i < nums.length - 1; i++) {
            if(leftArr[i] >= rightArr[i + 1]) {
                count++;
            }
        }
        return count;
    }
}