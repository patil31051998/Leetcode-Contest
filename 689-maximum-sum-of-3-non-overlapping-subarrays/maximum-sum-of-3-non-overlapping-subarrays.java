class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int currSum, i;
        int[] sum = new int[nums.length - k + 1];
        int[][] dp = new int[sum.length][4];
        currSum = 0;
        for(i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(i = 0; i < k; i++) {
            currSum += nums[i];
        }
        sum[0] = currSum;
        for(i = k; i < nums.length; i++) {
            sum[i - k + 1] = sum[i - k] + nums[i] - nums[i - k];
        }
        getMaxSum(k, sum, 0, 0, dp);
        return getMaxRes(k, sum, dp);
    }

    private int[] getMaxRes(int k, int[] sum, int[][] dp) {
        int ind, count;
        int[] res = new int[3];
        count = 0;
        ind = 0;
       while(ind < sum.length && count < 3) {
            int include = sum[ind] + getMaxSum(k, sum, ind + k, count + 1, dp);
            int exclude = getMaxSum(k, sum, ind + 1, count, dp);
            if(include >= exclude) {
                res[count] = ind;
                count++;
                ind = ind + k;
            }
            else {
                ind = ind + 1;
            }
        }
        return res;
    }

    private int getMaxSum(int k, int[] sum, int ind, int count, int[][] dp) {
        if(count == 3 || ind >= sum.length) {
            return 0;
        }
        if(dp[ind][count] != -1) {
            return dp[ind][count];
        }
        int include = sum[ind] + getMaxSum(k, sum, ind + k, count + 1, dp);
        int exclude = getMaxSum(k, sum, ind + 1, count, dp);
        return dp[ind][count] = Math.max(include, exclude);
    }
}