class Solution {
    public boolean canPartition(int[] nums) {
        int sum;
        sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return canPartition(nums, sum / 2, 0, dp);
    }

    private boolean canPartition(int[] nums, int sum, int i, int[][] dp) {
        if(sum == 0) {
            return true;
        }
        if(i == nums.length) {
            return false;
        }
        if(dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean notTake, take;
        take = false;
        notTake = canPartition(nums, sum, i + 1, dp);
        if(nums[i] <= sum) {
            take = canPartition(nums, sum - nums[i], i + 1, dp);
        }
        dp[i][sum] = take || notTake == true ? 1 : 0;
        return take || notTake;
    }
}