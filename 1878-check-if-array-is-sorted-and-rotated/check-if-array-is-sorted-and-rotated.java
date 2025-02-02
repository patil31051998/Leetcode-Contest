class Solution {
    public boolean check(int[] nums) {
        int max, i, rotInd;
        max = nums[0];
        rotInd = -1;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                if(rotInd != -1) {
                    return false;
                }
                rotInd = i - 1;
            }
            max = Math.max(max, nums[i]);
        }
        return rotInd == -1 || (nums[rotInd] == max && nums[0] >= nums[nums.length - 1]);
    }
}